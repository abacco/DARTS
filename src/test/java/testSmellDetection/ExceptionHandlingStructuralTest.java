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
    private static final int THRESHOLD_0 = 0;
    private static final int THRESHOLD_2 = 2;
    private static final int THRESHOLD_5 = 5;
    private static final int THRESHOLD_minus1 = -1;
    private static final int THRESHOLD_6 = 6;

    @Test
    public void testTC_Sys_16(){
        super.setFileName("test/TestEH_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_17(){
        super.setFileName("test/TestEH_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_18(){
        super.setFileName("test/TestEH_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_19(){
        super.setFileName("test/TestEH_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_20(){
        super.setFileName("test/TestEH_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_21(){
        super.setFileName("test/TestEH_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_22(){
        super.setFileName("test/TestEH_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_23(){
        super.setFileName("test/TestEH_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_24(){
        super.setFileName("test/TestEH_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_25(){
        super.setFileName("test/TestEH_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }@Test
    public void testTC_Sys_26(){
        super.setFileName("test/TestEH_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(3, smellList.size());
    }
    @Test
    public void testTC_Sys_27(){
        super.setFileName("test/TestEH_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(2, smellList.size());
    }
    @Test
    public void testTC_Sys_28(){
        super.setFileName("test/TestEH_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_29(){
        super.setFileName("test/TestEH_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_30(){
        super.setFileName("test/TestEH_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList =
                ExceptionHandlingStructural.checkMethodsThatContainExceptions(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }

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
