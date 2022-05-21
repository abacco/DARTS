package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.ExceptionHandlingStructural;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.MethodWithExceptionHandling;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import testConfiguration.TestConfig;
import java.util.ArrayList;

public class ExceptionHandlingStructuralTest extends TestConfig {
    private static final int THRESHOLD_1 = 1;
    private static final int THRESHOLD_0 = 0;

    @Test
    public void testExceptionHandlingNotPresent() {
        super.setFileName("test/ExceptionTestNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList = ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(null, smellList);
    }
    @Test
    public void testExceptionHandlingPresent() {
        super.setFileName("test/ExceptionTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList = ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(2, smellList.size());
    }
}
