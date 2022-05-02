package testSmellDetection.textualRules;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.MethodWithExceptionHandling;
import testSmellDetection.testSmellInfo.constructorInitialization.MethodWithConstructorInitialization;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class ExceptionHandlingTest extends LightJavaCodeInsightFixtureTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testdata/";
    }

    public void testExceptionHandlingNotPresent() {
        myFixture.configureByFile("test/ExceptionTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList = ExceptionHandlingTextual.checkMethodsThatContainExceptions(testClassBeans.get(0));
        assertEquals(null, smellList);
    }

    public void testExceptionHandling() {
        myFixture.configureByFile("test/ExceptionTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithExceptionHandling> smellList = ExceptionHandlingTextual.checkMethodsThatContainExceptions(testClassBeans.get(0));
        assertEquals(1, smellList.size());
    }
}
