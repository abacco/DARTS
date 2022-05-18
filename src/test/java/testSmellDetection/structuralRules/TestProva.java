package testSmellDetection.structuralRules;

import org.junit.jupiter.api.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class TestProva extends TestConfig{

    @Test
    public void test(){
        super.setFileName("CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicStructural.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0),0);
        assertEquals(3, smellList.size());
    }
}
