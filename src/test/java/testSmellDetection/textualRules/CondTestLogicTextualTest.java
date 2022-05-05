package testSmellDetection.textualRules;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import java.util.ArrayList;

public class CondTestLogicTextualTest extends LightJavaCodeInsightFixtureTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testdata/";
    }

    public void testCondTestLogicNotPresent() {
        myFixture.configureByFile("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicTextual.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0));
        assertEquals(null, smellList);
    }

    public void testCondTestLogicPresent() {
        myFixture.configureByFile("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithCondTestLogic> smellList = CondTestLogicTextual.checkMethodsThatCauseCondTestLogic(testClassBeans.get(0));
        assertEquals(3, smellList.size());
    }
}
