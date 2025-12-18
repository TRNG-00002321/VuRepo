package com.revature.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @Order(1)
    @DisplayName("GET /posts should return 200 and list of posts")
    void testGetAllPosts() {
        given()
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .log().status()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("size()", equalTo(100))
                .body("[0].id", equalTo(1))
                .body("[0].userId", equalTo(1));
    }

    @Test
    @Order(2)
    @DisplayName("GET /posts/1 should return specific post")
    void testGetPostById() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", not(emptyString()))
                .body("body", not(emptyString()))
                .body("userId", equalTo(1));
    }

    @Test
    @Order(3)
    @DisplayName("GET /posts?userId=1")
    void testGetAllPostsByUserId() {
        given()
                .baseUri(RestAssured.baseURI)
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("userId", everyItem(equalTo(1)));
    }
    @Test
    @Order(4)
    @DisplayName("POST /posts should create new post")
    void testCreatePost() {

        String requestBody = """
        {
            "title": "REST Assured Test Post",
            "body": "This post was created using REST Assured",
            "userId": 1
        }
        """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post("/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("REST Assured Test Post"))
                .body("userId", equalTo(1));
    }
    @Test
    @Order(5)
    @DisplayName("POST /posts with Map body")
    void testCreatePostWithMap(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "REST Assured Test Post");
        requestBody.put("body", "This post was created using REST Assured");
        requestBody.put("userId", 2);

        given()
        .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("userId", equalTo(2));
    }

    @Test
    @Order(6)
    @DisplayName("PUT /posts/1 should update post")
    void testUpdatePost() {
        String requestBody = """
        {
            "id": 1,
            "title": "Updated Title",
            "body": "Updated body content",
            "userId": 1
        }
        """;
        given()
                .baseUri(RestAssured.baseURI)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", equalTo("Updated Title"))
                .body("body", equalTo("Updated body content"));
    }

    @Test
    @Order(7)
    @DisplayName("Add a PATCH request test (partial update)")
    void testPatchRequest() {
        String requestBody = """
        {
            "title": "Updated Title via PATCH"
        }
        """;
        given()
                .baseUri(RestAssured.baseURI)
        .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title via PATCH"));
    }

    @Test
    @Order(8)
    @DisplayName("Test updating with invalid data (negative test)")
    void testUpdateInvalidData() {
        String requestBody = """
        {
            "id": "asda"
        }
        """;
        given()
        .baseUri(RestAssured.baseURI)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(400);

    }

    @Test
    @Order(9)
    @DisplayName("Extract and use response data")
    void testExtractAndUseResponseData() {
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // Access response properties
        int statusCode = response.getStatusCode();
        String contentType = response.getContentType();
        long responseTime = response.getTime();

        System.out.println("Status: " + statusCode);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Response Time: " + responseTime + "ms");

        // Extract specific values
        int postId = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        int userId = response.jsonPath().getInt("userId");

        System.out.println("Post ID: " + postId);
        System.out.println("Title: " + title);
        System.out.println("User ID: " + userId);

        // Use extracted data in assertions
        Assertions.assertEquals(1, postId);
        Assertions.assertNotNull(title);
    }

    @Test
    @Order(10)
    @DisplayName("Extracts a post ID from creation, then uses it to fetch the post")
    void testCreateAndRetrievePost() {
        int postId =
                given()
                        .baseUri(RestAssured.baseURI)
                        .contentType(ContentType.JSON)
                        .body("{\"title\":\"Integration Test Post\",\"body\":\"This is a test body\",\"userId\":1}")
                        .when()
                        .post("/posts")
                        .then()
                        .statusCode(201)
                        .extract()
                        .path("id");

        given()
        .baseUri(RestAssured.baseURI)
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/" + postId)
                .then()
                .body("id", equalTo(postId))
                .statusCode(200)
                .body("title", equalTo("Integration Test Post"))
                .body("body", equalTo("This is a test body"))
                .body("userId", equalTo(1));
    }

    @Test
    @DisplayName("Extract all titles from /posts and verify none are empty")
    void testVerifyNoEmptyTitles(){
        Response response = given()
                .when()
                .get("/posts")
                .then()
                .extract()
                .response();

        List<String> titles = response.jsonPath().getList("title");
        assertThat(titles, everyItem(allOf(notNullValue(), not(isEmptyString()))));
    }

    @Test
    @DisplayName("GET with query parameters")
    void testQueryParameters(){
        given()
                .queryParam("userId", 1)
                .queryParam("_limit", 5)
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5))
                .body("userId", everyItem(equalTo(1)));
    }


}