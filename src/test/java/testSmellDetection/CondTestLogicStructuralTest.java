package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.CondTestLogicStructural;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import java.util.ArrayList;
import testConfiguration.TestConfig;

public class CondTestLogicStructuralTest extends TestConfig {
    private static final int THRESHOLD_0 = 0;
    private static final int THRESHOLD_2 = 2;
    private static final int THRESHOLD_5 = 5;
    private static final int THRESHOLD_minus1 = -1;
    private static final int THRESHOLD_6 = 6;

    @Test
    public void testTC_Sys_01(){
        super.setFileName("test/TestCTL_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_02(){
        super.setFileName("test/TestCTL_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_03(){
        super.setFileName("test/TestCTL_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_04(){
        super.setFileName("test/TestCTL_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_05(){
        super.setFileName("test/TestCTL_Sys_0_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_06(){
        super.setFileName("test/TestCTL_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_07(){
        super.setFileName("test/TestCTL_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_08(){
        super.setFileName("test/TestCTL_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_09(){
        super.setFileName("test/TestCTL_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_10(){
        super.setFileName("test/TestCTL_Sys_1_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_11(){
        super.setFileName("test/TestCTL_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(3, smellList.size());
    }
    @Test
    public void testTC_Sys_12(){
        super.setFileName("test/TestCTL_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_2);
        assertEquals(2, smellList.size());
    }
    @Test
    public void testTC_Sys_13(){
        super.setFileName("test/TestCTL_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_5);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testTC_Sys_14(){
        super.setFileName("test/TestCTL_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_minus1);
        assertEquals(null, smellList);
    }
    @Test
    public void testTC_Sys_15(){
        super.setFileName("test/TestCTL_Sys_2opiu_instance.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList =
                CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_6);
        assertEquals(null, smellList);
    }

    @Test
    public void testCondTestLogicNotPresent() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),1);
        assertEquals(null, smellList);
    }
    @Test
    public void testCondTestLogicPresentThreshold0() {
        super.setFileName("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(3, smellList.size());
    }
    @Test
    public void testCondTestLogicPresentThreshold1() {
        super.setFileName("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),1);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testCondTestLogicPresentIf() {
        super.setFileName("test/CondTestLogicPresentIf.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testCondTestLogicPresentSwitch() {
        super.setFileName("test/CondTestLogicPresentSwitch.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(1, smellList.size());
    }
    @Test
    public void testCondTestLogicPresentLoopStatement() {
        super.setFileName("test/CondTestLogicPresentLoopStatement.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_0);
        assertEquals(2, smellList.size());
    }
}
