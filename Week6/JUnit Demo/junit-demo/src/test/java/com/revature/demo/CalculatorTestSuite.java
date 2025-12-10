package com.revature.demo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorTest.class,
        CalculatorTestAdd.class
})

public class CalculatorTestSuite {

}
