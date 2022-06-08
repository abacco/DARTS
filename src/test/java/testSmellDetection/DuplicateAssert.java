package testSmellDetection;

import org.junit.Test;
import testConfiguration.TestConfig;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.DuplicateAssertStructural;
import testSmellDetection.testSmellInfo.DuplicateAssert.MethodWithDuplicateAssert;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class DuplicateAssert extends TestConfig {

    @Test
    public void testDuplicateAssertPresent() {
        super.setFileName("test/DuplicateAssertPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }

    @Test
    public void testDuplicateAssertNotPresent() {
        super.setFileName("test/DuplicateAssertNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithDuplicateAssert> smellList = DuplicateAssertStructural.checkMethodsThatCauseDuplicateAssert(testClassBeans.get(0));
        assertEquals(0, smellList.size());
    }
}
