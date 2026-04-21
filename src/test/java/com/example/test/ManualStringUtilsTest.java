package com.example.test;

import org.apache.commons.lang3.StringUtils;

/**
 * 手动单元测试类，不依赖任何测试框架（如 JUnit）。
 * 通过 main 方法执行，验证 {@link StringUtils} 关键方法的正确性。
 */
public class ManualStringUtilsTest {

    private static int passed = 0;
    private static int failed = 0;
    private static int total = 0;

    public static void main(String[] args) {
        System.out.println("========== StringUtils 手动单元测试开始 ==========\n");

        // 测试 1：isNumeric（已注入缺陷）
        testIsNumeric();

        // 测试 2：isBlank
        testIsBlank();

        // 测试 3：leftPad
        testLeftPad();

        // 测试 4：substringBefore
        testSubstringBefore();

        // 打印测试总结
        System.out.println("\n========== 测试总结 ==========");
        System.out.println("总测试用例数: " + total);
        System.out.println("通过: " + passed);
        System.out.println("失败: " + failed);

        if (failed == 0) {
            System.out.println("所有测试通过！");
        } else {
            System.out.println("存在失败用例，请检查代码缺陷。");
            // 如果希望持续集成能捕获错误，可在此处返回非零状态码
            // System.exit(1);
        }
    }

    /**
     * 测试 isNumeric 方法
     * 预期：null/false；""/false；"123"/true；"12.3"/false
     * 注意：已注入缺陷，空字符串将错误返回 true，本测试会捕获该错误。
     */
    private static void testIsNumeric() {
        System.out.println("--- 测试方法：isNumeric ---");

        // 用例1：null 输入
        assertEquals("isNumeric(null)", false, StringUtils.isNumeric(null));

        // 用例2：空字符串（关键缺陷：预期 false，实际缺陷会返回 true）
        assertEquals("isNumeric(\"\")", false, StringUtils.isNumeric(""));

        // 用例3：纯数字字符串
        assertEquals("isNumeric(\"123\")", true, StringUtils.isNumeric("123"));

        // 用例4：带小数点（非纯数字）
        assertEquals("isNumeric(\"12.3\")", false, StringUtils.isNumeric("12.3"));

        // 用例5：包含字母
        assertEquals("isNumeric(\"12a\")", false, StringUtils.isNumeric("12a"));

        // 用例6：空格（非数字）
        assertEquals("isNumeric(\" \")", false, StringUtils.isNumeric(" "));
    }

    /**
     * 测试 isBlank 方法
     */
    private static void testIsBlank() {
        System.out.println("\n--- 测试方法：isBlank ---");

        assertEquals("isBlank(null)", true, StringUtils.isBlank(null));
        assertEquals("isBlank(\"\")", true, StringUtils.isBlank(""));
        assertEquals("isBlank(\" \")", true, StringUtils.isBlank(" "));
        assertEquals("isBlank(\"  \")", true, StringUtils.isBlank("  "));
        assertEquals("isBlank(\"abc\")", false, StringUtils.isBlank("abc"));
        assertEquals("isBlank(\" abc \")", false, StringUtils.isBlank(" abc "));
    }

    /**
     * 测试 leftPad 方法
     */
    private static void testLeftPad() {
        System.out.println("\n--- 测试方法：leftPad ---");

        assertEquals("leftPad(null, 5, '*')", null, StringUtils.leftPad(null, 5, '*'));
        assertEquals("leftPad(\"\", 3, '-')", "---", StringUtils.leftPad("", 3, '-'));
        assertEquals("leftPad(\"abc\", 5, '*')", "**abc", StringUtils.leftPad("abc", 5, '*'));
        assertEquals("leftPad(\"abc\", 3, '*')", "abc", StringUtils.leftPad("abc", 3, '*'));
        assertEquals("leftPad(\"abc\", 1, '*')", "abc", StringUtils.leftPad("abc", 1, '*'));
    }

    /**
     * 测试 substringBefore 方法
     */
    private static void testSubstringBefore() {
        System.out.println("\n--- 测试方法：substringBefore ---");

        assertEquals("substringBefore(null, \"a\")", null, StringUtils.substringBefore(null, "a"));
        assertEquals("substringBefore(\"\", \"a\")", "", StringUtils.substringBefore("", "a"));
        assertEquals("substringBefore(\"abc\", null)", "abc", StringUtils.substringBefore("abc", null));
        assertEquals("substringBefore(\"abc\", \"\")", "", StringUtils.substringBefore("abc", ""));
        assertEquals("substringBefore(\"abc\", \"a\")", "", StringUtils.substringBefore("abc", "a"));
        assertEquals("substringBefore(\"abcba\", \"b\")", "a", StringUtils.substringBefore("abcba", "b"));
        assertEquals("substringBefore(\"abc\", \"c\")", "ab", StringUtils.substringBefore("abc", "c"));
        assertEquals("substringBefore(\"abc\", \"d\")", "abc", StringUtils.substringBefore("abc", "d"));
    }

    /**
     * 自定义断言，比较预期值和实际值，并记录测试结果。
     *
     * @param caseName 测试用例名称
     * @param expected 预期值
     * @param actual   实际值
     */
    private static void assertEquals(String caseName, Object expected, Object actual) {
        total++;
        if (expected == null && actual == null) {
            passed++;
            System.out.println("✅ " + caseName + " 通过 (null)");
        } else if (expected != null && expected.equals(actual)) {
            passed++;
            System.out.println("✅ " + caseName + " 通过");
        } else {
            failed++;
            System.out.println("❌ " + caseName + " 失败");
            System.out.println("   预期: " + (expected == null ? "null" : "\"" + expected + "\""));
            System.out.println("   实际: " + (actual == null ? "null" : "\"" + actual + "\""));
        }
    }
}