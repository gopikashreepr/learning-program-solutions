package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MathUtilsTest.class, EvenCheckerTest.class })
public class AllTests {
    // no code needed
}
