package testSmellDetection.textualRules;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import java.util.ArrayList;

public class MagicNumberTextualTest extends LightJavaCodeInsightFixtureTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testdata/";
    }

    public void testMagicNumberNotPresent() {
        myFixture.configureByFile("test/MagicNumberNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberTextual.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(null, smellList);
    }

    public void testMagicNumberPresent() {
        myFixture.configureByFile("test/MagicNumberPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithMagicNumber> smellList = MagicNumberTextual.checkMethodsThatCauseMagicNumber(testClassBeans.get(0));
        assertEquals(3, smellList.size());
    }
}
