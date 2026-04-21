package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsSubstringBeforeTest {

    @Test
    public void testSubstringBefore_nullString_returnsNull() {
        assertNull(StringUtils.substringBefore(null, "a"));
    }

    @Test
    public void testSubstringBefore_emptyString_returnsEmpty() {
        assertEquals("", StringUtils.substringBefore("", "a"));
    }

    @Test
    public void testSubstringBefore_nullSeparator_returnsOriginal() {
        assertEquals("abc", StringUtils.substringBefore("abc", null));
    }

    @Test
    public void testSubstringBefore_emptySeparator_returnsEmpty() {
        assertEquals("", StringUtils.substringBefore("abc", ""));
    }

    @Test
    public void testSubstringBefore_separatorNotFound_returnsOriginal() {
        assertEquals("abc", StringUtils.substringBefore("abc", "d"));
    }

    @Test
    public void testSubstringBefore_separatorAtStart_returnsEmpty() {
        assertEquals("", StringUtils.substringBefore("abc", "a"));
    }

    @Test
    public void testSubstringBefore_separatorInMiddle_returnsPrefix() {
        assertEquals("a", StringUtils.substringBefore("abcba", "b"));
        assertEquals("ab", StringUtils.substringBefore("abc", "c"));
    }
}
