package dartsFuncionality;

import org.junit.Test;
import testConfiguration.TestConfig;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.structuralRules.EagerTestStructural;
import testSmellDetection.testSmellInfo.eagerTest.MethodWithEagerTest;
import testSmellDetection.textualRules.EagerTestTextual;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import java.util.ArrayList;

public class EagerTestStructuralTest extends TestConfig {
    @Test
    public void testIsEagerFalse() {
        super.setFileName("test/EagerTestNotPresentTest.java");
        super.setFileName("main/EagerTestNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<PsiClassBean> prodClassBeans = TestSmellUtilities.getAllProductionClasses(psiClassBeans,testClassBeans);
        Boolean isEager = EagerTestStructural.isEagerTest(testClassBeans.get(0),testClassBeans, prodClassBeans);
        assertFalse(isEager);
    }

    @Test
    public void testIsEagerTrue() {
        super.setFileName("test/EagerTestPresentTest.java");
        super.setFileName("main/EagerTestPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        ArrayList<PsiClassBean> prodClassBeans = TestSmellUtilities.getAllProductionClasses(psiClassBeans,testClassBeans);
        Boolean isEager = EagerTestStructural.isEagerTest(testClassBeans.get(0),testClassBeans, prodClassBeans);
        assertTrue(isEager);
    }
}
