package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试 isNumeric 方法（包含注入缺陷的边界用例）
 */
public class StringUtilsIsNumericTest {

    @Test
    public void testIsNumeric_null_returnsFalse() {
        assertFalse(StringUtils.isNumeric(null));
    }

    @Test
    public void testIsNumeric_emptyString_returnsFalse() {
        // 此用例将暴露缺陷：缺陷版本会返回 true，导致断言失败
        assertFalse(StringUtils.isNumeric(""));
    }

    @Test
    public void testIsNumeric_pureDigits_returnsTrue() {
        assertTrue(StringUtils.isNumeric("123"));
        assertTrue(StringUtils.isNumeric("0"));
    }

    @Test
    public void testIsNumeric_withDecimalPoint_returnsFalse() {
        assertFalse(StringUtils.isNumeric("12.3"));
    }

    @Test
    public void testIsNumeric_withLetter_returnsFalse() {
        assertFalse(StringUtils.isNumeric("12a"));
    }

    @Test
    public void testIsNumeric_withSpace_returnsFalse() {
        assertFalse(StringUtils.isNumeric(" "));
    }
}