package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsIsBlankTest {

    @Test
    public void testIsBlank_null_returnsTrue() {
        assertTrue(StringUtils.isBlank(null));
    }

    @Test
    public void testIsBlank_empty_returnsTrue() {
        assertTrue(StringUtils.isBlank(""));
    }

    @Test
    public void testIsBlank_whitespace_returnsTrue() {
        assertTrue(StringUtils.isBlank(" "));
        assertTrue(StringUtils.isBlank("  \t\n"));
    }

    @Test
    public void testIsBlank_nonEmpty_returnsFalse() {
        assertFalse(StringUtils.isBlank("abc"));
        assertFalse(StringUtils.isBlank(" abc "));
    }
}