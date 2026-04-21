package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsLeftPadTest {

    @Test
    public void testLeftPad_null_returnsNull() {
        assertNull(StringUtils.leftPad(null, 5, '*'));
    }

    @Test
    public void testLeftPad_emptyString_padsCorrectly() {
        assertEquals("---", StringUtils.leftPad("", 3, '-'));
    }

    @Test
    public void testLeftPad_shorterString_padsCorrectly() {
        assertEquals("**abc", StringUtils.leftPad("abc", 5, '*'));
    }

    @Test
    public void testLeftPad_equalLength_returnsOriginal() {
        assertEquals("abc", StringUtils.leftPad("abc", 3, '*'));
    }

    @Test
    public void testLeftPad_smallerSize_returnsOriginal() {
        assertEquals("abc", StringUtils.leftPad("abc", 1, '*'));
    }
}