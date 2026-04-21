package com.example.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * JUnit 测试套件，将多个测试类打包批量运行。
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    StringUtilsIsNumericTest.class,
    StringUtilsIsBlankTest.class,
    StringUtilsLeftPadTest.class,
    StringUtilsSubstringBeforeTest.class
})
public class StringUtilsTestSuite {
    // 此类不需要任何代码，仅作为套件入口
}