package testSmellDetection;

import org.junit.Test;
import testConfiguration.TestConfig;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.structuralRules.IgnoredTestStructural;
import testSmellDetection.testSmellInfo.IgnoredTest.MethodWithIgnoredTest;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class IgnoredTest extends TestConfig {
    @Test
    public void testIgnoredTestPresent() {
        super.setFileName("test/IgnoredTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithIgnoredTest> smellList = IgnoredTestStructural.checkMethodsThatIgnoredTest(testClassBeans.get(0));
        assertEquals(1, smellList);
    }
    @Test
    public void testIgnoredTestNotPresent() {
        super.setFileName("test/IgnoredTestNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithIgnoredTest> smellList = IgnoredTestStructural.checkMethodsThatIgnoredTest(testClassBeans.get(0));
        assertEquals(0, smellList.size());
    }
}

