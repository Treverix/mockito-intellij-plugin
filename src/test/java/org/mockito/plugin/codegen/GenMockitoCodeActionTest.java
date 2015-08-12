package org.mockito.plugin.codegen;

import org.junit.Test;

/**
 * Created by przemek on 8/9/15.
 */
public class GenMockitoCodeActionTest extends MockitoPluginPsiTestCase {

    @Test
    public void testInsertIgnoresFileWithMockitoRunner() throws Exception {
        testFile("codegen/beforeClassWithMockitoRunnerTest.java", "codegen/afterClassWithMockitoRunnerTest.java");
    }

    @Test
    public void testInsertUnderTestFieldWhenUnderTestFieldAdded() throws Exception {
        testFile("codegen/beforeEmptyClassTest.java", "codegen/afterEmptyClassTest.java");
    }

    @Test
    public void testInsertUnderTestFieldWhenItIsAlreadyPresent() throws Exception {
        testFile("codegen/beforeClassWithUnderTestField.java", "codegen/afterClassWithUnderTestField.java");
    }

    @Test
    public void testInsertUnderTestFieldWhenClassHasOtherFields() throws Exception {
        testFile("codegen/beforeClassWithFieldsAndMethodsTest.java",
                "codegen/afterClassWithFieldsAndMethodsTest.java");
    }

    @Test
    public void testInsertIgnoresFileWithAllMocksInserted() throws Exception {
        testFile("codegen/afterClassWithAllMocksTest.java",
                "codegen/afterClassWithAllMocksTest.java");
    }

    @Test
    public void testInsertIgnoresStaticField() throws Exception {
        testFile("codegen/beforeClassWithStaticFieldsTest.java",
                "codegen/afterClassWithStaticFieldsTest.java");
    }

    @Test
    public void testOtherThanJavaFileIgnored() throws Exception {
        testFile("codegen/beforeNonJavaFileTest.groovy",
                "codegen/beforeNonJavaFileTest.groovy");
    }

    @Test
    public void testFinalClassFieldsIgnored() throws Exception {
        testFile("codegen/beforeClassWithFinalClassFieldTest.java",
                "codegen/afterClassWithFinalClassFieldTest.java");
    }
}