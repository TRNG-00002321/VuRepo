package com.revature.demo;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    @Test
    @DisplayName("Testing Add Method")
    @Order(1)
    void testAdd(){
        //Arrange
        Calculator calc = new Calculator();
        int n1=10;
        int n2=12;
        int expected =22;
        int actual;

        //Act
        actual = calc.add(n1,n2);

        //Assert
        Assertions.assertEquals(expected,actual);

    }


    @Test
    @DisplayName("Test Negative")
    @Disabled
    void testAddNegative(){
        //Arrange
        Calculator calc = new Calculator();
        int n1=-10;
        int n2=12;
        int expected =22;
        int actual;

        //Act
        actual = calc.add(n1,n2);

        //Assert
        Assertions.assertEquals(expected,actual);
    }

    /*@BeforeEach
    public void setUp(){
        System.out.println("This is the set up method ... before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("This is the set up method ... after each");
    }

    @BeforeAll
    public static void setupClass(){
        System.out.println("Before all method is called");
    }

    @AfterAll
    public static void tearDownClass(){
        System.out.println("After all method is called");
    }*/

    @Test
    void testSubtract(){
        Calculator calc = new Calculator();
        int n1=20;
        int n2=12;
        int expected =8;
        int actual;

        actual=calc.sub(n1,n2);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testMultiply(){
        Calculator calc = new Calculator();
        int n1=3;
        int n2=2;
        int expected =6;
        int actual;
        actual=calc.mul(n1,n2);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testDivideThrow(){
        Calculator calc = new Calculator();
        int n1=8;
        int n2=0;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            calc.div(n1,n2);
        });
    }

    @Test
    void testDivide(){
        Calculator calc = new Calculator();
        int n1=8;
        int n2=2;
        int expected =4;
        double actual;
        actual=calc.div(n1,n2);
        Assertions.assertEquals(expected,actual);
    }
}
