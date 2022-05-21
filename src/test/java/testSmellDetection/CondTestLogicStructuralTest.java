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
    private static final int THRESHOLD_1 = 1;
    private static final int THRESHOLD_0 = 0;

    @Test
    public void testCondTestLogicNotPresent() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_1);
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
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),THRESHOLD_1);
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
