package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoRestCRUD {
    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;
    static int createdPostId;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Custom_Header", "RestAssuredDemo")
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    @AfterAll
    static void teardown() {
        RestAssured.reset();
    }

    @Test
    public void getPost(){
        given()
                .spec(requestSpecification)
                .when()
                .get("/posts/1")
                .then()
                .spec(responseSpecification)
                .statusCode(200);
    }

    @Test
    @Order(1)
    @DisplayName("CREATE - POST new post")
    void create_post_returnsCreatedResource() {
        // Request body as JSON string
        String requestBody = """
            {
                "title": "Test Post from REST Assured",
                "body": "This post was created during our demo",
                "userId": 1
            }
            """;

        Response response = given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  // Created
                .body("title", equalTo("Test Post from REST Assured"))
                .body("body", containsString("demo"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        // Store ID for later tests
        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    @Test
    @Order(2)
    @DisplayName("Create - Post with Java Object")
    public void testSerialObject(){
        // Simple inner class for demo (normally in separate file)
        record Post(int id, String title, String body) {}

        Post newPost = new Post(1,"POJO Test", "Testing a POJO Object");

        Response response = given()
                .spec(requestSpecification)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  // Created
                .body("title", equalTo("POJO Test"))
                .body("body", containsString("POJO"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        // Store ID for later tests
        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    @ParameterizedTest(name = "User {0} has name {1}")
    @CsvSource({
            "1, Leanne Graham",
            "2, Ervin Howell",
            "3, Clementine Bauch",
            "4, Patricia Lebsack",
            "5, Chelsey Dietrich"
    })
    public void getIndividualPost(int userId, String expectedName){
        given()
                .when()
                .get("/users/"+userId)
                .then()
                .statusCode(200)
        .body("name", equalTo(expectedName));
    }

    @Test
    @Order(3)
    @DisplayName("Complete CRUD flow in single test")
    void completeCrudFlow_createReadUpdateDelete() {

        // CREATE
        String createBody = """
            {
                "title": "CRUD Test Post",
                "body": "Testing complete CRUD flow",
                "userId": 1
            }
            """;

        int newId = given()
                .spec(requestSpecification)
                .body(createBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("CRUD Test Post"))
                .extract()
                .path("id");

        System.out.println("Created ID: " + newId);

        // READ
        given()
                .spec(requestSpecification)
                .when()
                .get("/posts/" + newId)
                .then()
                .statusCode(200)
                .body("id", equalTo(newId));

        // UPDATE
        String updateBody = """
            {
                "id": %d,
                "title": "Updated CRUD Test",
                "body": "Body was updated",
                "userId": 1
            }
            """.formatted(newId);

        given()
                .spec(requestSpecification)
                .body(updateBody)
                .when()
                .put("/posts/" + newId)
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated CRUD Test"));

        // DELETE
        given()
                .spec(requestSpecification)
                .when()
                .delete("/posts/" + newId)
                .then()
                .statusCode(200);

        System.out.println("CRUD flow completed successfully!");
    }

    @Test
    @DisplayName("Extract and assert with JUnit")
    void extractAndAssert_withJUnit() {
        var response = given()
                .when()
                .get("/users")
                .then()
                .extract()
                .response();

        // JUnit assertions
        int statusCode = response.statusCode();
        Assertions.assertEquals(200, statusCode, "Status should be 200");

        int userCount = response.jsonPath().getList("$").size();
        Assertions.assertEquals(10, userCount, "Should have 10 users");

        String firstUserName = response.jsonPath().getString("[0].name");
        Assertions.assertNotNull(firstUserName, "First user should have a name");
        Assertions.assertFalse(firstUserName.isEmpty(), "Name should not be empty");
    }


}
