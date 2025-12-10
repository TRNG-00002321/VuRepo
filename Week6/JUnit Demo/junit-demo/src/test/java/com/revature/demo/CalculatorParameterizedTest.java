package com.revature.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorParameterizedTest {
    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 2, 3",
            "2, 2, 4"
    })
    public void testAdd(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.add(a,b));
    }

    @ParameterizedTest(name = "Adding {0} and {1} is {2}")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    public void testAddAgain(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.add(a,b));
    }

    @ParameterizedTest(name = "Adding {0} and {1} is {2} using method")
    @MethodSource("testDataMethod")
    public void testAddThird(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.add(a,b));
    }

    static Stream<Arguments> testDataMethod(){
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(-2,4,2)
                );
    }

    @ParameterizedTest(name = "Subtracting {0} and {1} is {2}")
    @CsvFileSource(resources = "/testDataSub.csv", numLinesToSkip = 1)
    public void testSub(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.sub(a,b));
    }

    @ParameterizedTest(name = "Multiplying {0} and {1} is {2}")
    @CsvFileSource(resources = "/testDataMul.csv", numLinesToSkip = 1)
    public void testMul(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.mul(a,b));
    }

    @ParameterizedTest(name = "Dividing {0} and {1} is {2}")
    @CsvFileSource(resources = "/testDataDiv.csv", numLinesToSkip = 1)
    public void testDiv(int a, int b, int expected) {
        Assertions.assertEquals(expected,calculator.div(a,b));
    }


}
