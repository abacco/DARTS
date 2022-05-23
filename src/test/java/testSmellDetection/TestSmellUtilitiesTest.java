package testSmellDetection;

import org.junit.Test;
import org.mockito.Mockito;
import testSmellDetection.bean.PsiClassBean;
import utility.ConverterUtilities;
import utility.TestSmellUtilities;

import testConfiguration.TestConfig;
import java.util.ArrayList;

public class TestSmellUtilitiesTest extends TestConfig {

    private ArrayList<PsiClassBean> psiClassBeans;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myFixture.configureByFile("test/CondTestLogicNotPresentTest.java");
        psiClassBeans = Mockito.mock(ConverterUtilities.class).getClassesFromPackages(getProject());
    }
    @Test
    public void testSmellUtilitiesNotNull() {
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertNotNull(testClassBeans);
    }
    @Test
    public void testSmellUtilitiesIstanceOfArrayList() {
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertInstanceOf(testClassBeans,ArrayList.class);
    }
    @Test
    public void testSmellUtilitiesIstanceOfPsiClassBean() {
        ArrayList<PsiClassBean> testClassBeans = TestSmellUtilities.getAllTestClasses(psiClassBeans);
        assertInstanceOf(testClassBeans.get(0),PsiClassBean.class);
    }
}
