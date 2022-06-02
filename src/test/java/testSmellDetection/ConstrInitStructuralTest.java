package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.ConstructorInitStructural;
import testSmellDetection.testSmellInfo.constructorInitialization.MethodWithConstructorInitialization;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import testConfiguration.TestConfig;
import java.util.ArrayList;

public class ConstrInitStructuralTest extends TestConfig {

    @Test
    public void testTC_Sys_31(){
        super.setFileName("test/TestCI_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithConstructorInitialization> smellList = ConstructorInitStructural.checkMethodsThatCauseConstructorInitialization(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_32(){
        super.setFileName("test/TestCI_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithConstructorInitialization> smellList = ConstructorInitStructural.checkMethodsThatCauseConstructorInitialization(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_33(){
        super.setFileName("test/TestCI_Sys_2piu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithConstructorInitialization> smellList = ConstructorInitStructural.checkMethodsThatCauseConstructorInitialization(testClassBeans.get(0));
        assertEquals(2, smellList.size());
    }

    @Test
    public void testConstructorNotPresent() {
        super.setFileName("test/ConstructorInitializationNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithConstructorInitialization> smellList = ConstructorInitStructural.checkMethodsThatCauseConstructorInitialization(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
    @Test
    public void testConstructorPresent() {
        super.setFileName("test/ConstructorInitializationPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithConstructorInitialization> smellList = ConstructorInitStructural.checkMethodsThatCauseConstructorInitialization(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }
}
