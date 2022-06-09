package testSmellDetection;

import org.junit.Test;
import testConfiguration.TestConfig;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.DuplicateAssertStructural;
import testSmellDetection.structuralRules.IgnoredTestStructural;
import testSmellDetection.testSmellInfo.DuplicateAssert.MethodWithDuplicateAssert;
import testSmellDetection.testSmellInfo.IgnoredTest.MethodWithIgnoredTest;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class DuplicateAssertTest extends TestConfig {

    @Test
    public void testTC_Sys_37(){
        super.setFileName("test/TestDA_Sys_0_Instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_38(){
        super.setFileName("test/TestDA_Sys_1_Instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_39(){
        super.setFileName("test/TestDA_Sys_2opiu_Instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(2, smellList.size());
    }

    @Test
    public void testDuplicateAssertPresent() {
        super.setFileName("test/DuplicateAssertPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }

    @Test
    public void testDuplicateAssertNotPresent() {
        super.setFileName("test/DuplicateAssertNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
}
