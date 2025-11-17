import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(3,5);
        Assertions.assertEquals(8,result);
    }
}
