package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.MagicNumberStructural;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import testConfiguration.TestConfig;
import java.util.ArrayList;

public class MagicNumberStructuralTest extends TestConfig {

    @Test
    public void testTC_Sys_34(){
        super.setFileName("test/TestMN_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberStructural.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_35(){
        super.setFileName("test/TestMN_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberStructural.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_36(){
        super.setFileName("test/TestMN_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberStructural.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(2, smellList.size());
    }

    @Test
    public void testMagicNumberNotPresent() {
        super.setFileName("test/MagicNumberNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberStructural.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(null, smellList);
    }
    @Test
    public void testMagicNumberPresent() {
        super.setFileName("test/MagicNumberPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberStructural.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(3, smellList.size());
    }
}
