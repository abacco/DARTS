package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.eagerTest.MethodWithEagerTest;
import testSmellDetection.textualRules.EagerTestTextual;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import testConfiguration.TestConfig;
import java.util.ArrayList;

public class EagerTestTextualTest extends TestConfig {
    @Test
    public void testEagerTestNotPresent() {
        super.setFileName("test/EagerTestNotPresentTest.java");
        super.setFileName("main/EagerTestNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithEagerTest> smellList = EagerTestTextual.checkMethodsThatCauseEagerTest(testClassBeans.get(0), testClassBeans.get(0).getProductionClass());
        assertEquals(null, smellList);
    }
    @Test
    public void testEagerTestPresent() {
        super.setFileName("test/EagerTestPresentTest.java");
        super.setFileName("main/EagerTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<MethodWithEagerTest> smellList = EagerTestTextual.checkMethodsThatCauseEagerTest(testClassBeans.get(0), testClassBeans.get(0).getProductionClass());
        assertEquals(1, smellList.size());
    }
}