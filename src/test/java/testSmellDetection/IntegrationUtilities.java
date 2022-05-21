package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;
import testConfiguration.TestConfig;
import java.util.ArrayList;

public class IntegrationUtilities extends TestConfig {
    @Test
    public void testIntegrationUtilitiesNotNull() {
        super.setFileName("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertNotNull(testClassBeans);
    }
    @Test
    public void testIntegrationUtilitiesIstanceOfArrayList() {
        super.setFileName("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertInstanceOf(testClassBeans,ArrayList.class);
    }
    @Test
    public void testIntegrationUtilitiesIstanceOfPsiClassBean() {
        super.setFileName("test/CondTestLogicPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertInstanceOf(testClassBeans.get(0),PsiClassBean.class);
    }
}
