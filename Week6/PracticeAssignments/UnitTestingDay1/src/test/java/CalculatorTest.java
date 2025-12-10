import com.revature.assignments.utils.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Add two positive numbers")
    void add_twoPositiveNumbers_returnsSum() {
        int result = calculator.add(1, 2);
        assertEquals(3, result, "Adding 1 and 2 should return 3");
    }
    @Test
    @DisplayName("Add positive and negative numbers")
    void add_positiveAndNegativeNumbers_returnsSum() {
        int result = calculator.add(5, -1);
        assertEquals(4, result, "Adding 5 and -1 should return 4");
    }
    @Test
    @DisplayName("Add two negative numbers")
    void add_twoNegativeNumbers_returnsSum() {
        int result = calculator.add(-5, -2);
        assertEquals(-7, result, "Adding -5 and -2 should return -7");
    }
    @Test
    @DisplayName("Adding Zero")
    void add_zero_returnsSum() {
        int result = calculator.add(10, 0);
        assertEquals(10, result, "Adding 10 and 0 should return 10");
    }

    @Test
    @DisplayName("Subtract two number")
    void subtract_twoNumbers_returnsSum() {
        int result = calculator.subtract(5, 2);
        assertEquals(3, result, "Subtract 5 and 2 should return 3");
    }
    @Test
    @DisplayName("Subtract a larger number")
    void subtract_aLargerNumbers_returnsSum() {
        int result = calculator.subtract(5, 8);
        assertEquals(-3, result, "Subtract 5 and 8 should return -3");
    }
    @Test
    @DisplayName("Subtracting zero")
    void subtracting_zero_returnsSum() {
        int result = calculator.subtract(5, 0);
        assertEquals(5, result, "Subtract 5 and 0 should return 5");
    }

    @Test
    @DisplayName("Test even with positive number")
    void even_positiveNumber_returnsTrue() {
        boolean result = calculator.isEven(6);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test even with odd number")
    void even_oddNumber_returnsTrue() {
        boolean result = calculator.isEven(7);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test even with zero")
    void even_zero_returnsTrue() {
        boolean result = calculator.isEven(0);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test even with negative number")
    void even_negativeNumber_returnsTrue() {
        boolean result = calculator.isEven(-4);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test positive with positive number")
    void positive_positiveNumber_returnsTrue() {
        boolean result = calculator.isPositive(6);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test positive with negative number")
    void positive_negativeNumber_returnsTrue() {
        boolean result = calculator.isPositive(-4);
        assertFalse(result);
    }
    @Test
    @DisplayName("Test positive with zero")
    void positive_zero_returnsTrue() {
        boolean result = calculator.isPositive(0);
        assertFalse(result);
    }
}
