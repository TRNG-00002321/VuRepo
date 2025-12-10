package com.revature.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTestAdd {
    @Test
    void testAddition()
    {
        Calculator calc = new Calculator();
        int a=10;
        int b=10;
        int result=calc.add(a,b);

        //Act
        int actual=calc.add(a,b);

        //Assert
        Assertions.assertEquals(result,actual);

    }
}
