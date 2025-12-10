import com.revature.assignments.utils.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTestParamerized {
    private Calculator calculator;

    @BeforeEach
    public void setUp()
    {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,6,8,2,-4})
    void isEven_evenNumber_returnsTrue(int number)
    {
        assertTrue(calculator.isEven(number));
    }
    @ParameterizedTest
    @ValueSource(ints = {3,5,7,1,-5})
    void isEven_oddNumber_returnsFalse(int number){
        assertFalse(calculator.isEven(number));
    }
    @ParameterizedTest
    @ValueSource(ints = {1,4,7,3,8})
    void isPositive_positiveNumber_returnTrue(int number){
        assertTrue(calculator.isPositive(number));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,5,9",
            "3,-2,1",
            "4,1,5",
            "4,0,4",
            "-3,-2,-5"
    })
    void addition_sixCases_returnsTrue(int a, int b, int expected)
    {
        assertEquals(expected, calculator.add(a,b));
    }
    @ParameterizedTest
    @CsvSource({
            "5,3,2",
            "-5,-4,-1",
            "4,-3,7",
            "4,0,4"
    })
    void subtraction_fourCases_returnsTrue(int a, int b, int expected)
    {
        assertEquals(expected, calculator.subtract(a,b));
    }
    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-5, -4, 20",
            "4, -3, -12",
            "4, 0, 0"
    })
    void multiplication_fourCases_returnTrue(int a, int b, int expected)
    {
        assertEquals(expected, calculator.multiply(a,b));
    }
    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",
            "-8, -4, 2",
            "9, -3, -3",
            "4, 2, 2"
    })
    void division_fourCases_returnsTrue(int a, int b, int expected)
    {
        assertEquals(expected, calculator.divide(a,b));
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    void divide_variousCases_returnsTrue(int a, int b, int expected)
    {
        assertEquals(expected, calculator.divide(a,b));
    }
    static Stream<Arguments> getTestCases()
    {
        return Stream.of(
                Arguments.of(10,2,5),
                Arguments.of(9,3,3),
                Arguments.of(-10,2,-5),
                Arguments.of(7,2,3)
        );
    }
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @DisplayName("Display name demo")
    @CsvSource({"1, 2, 3", "4, 5, 9"})
    void add_customDisplayName(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

}
