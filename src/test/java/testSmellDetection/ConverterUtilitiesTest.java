package testSmellDetection;

import org.junit.Test;
import testSmellDetection.bean.PsiClassBean;
import utility.ConverterUtilities;

import testConfiguration.TestConfig;
import java.util.ArrayList;

public class ConverterUtilitiesTest extends TestConfig {
    @Test
    public void testConverterUtilitiesNotNull() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        assertNotNull("PsiClassBean not null",psiClassBeans);
    }
    @Test
    public void testConverterUtilitiesNull() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(null);
        assertNull("PsiClassBean null",psiClassBeans);
    }
    @Test
    public void testConverterUtilitiesIstanceOfPsiClassBean() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        assertInstanceOf(psiClassBeans.get(0),PsiClassBean.class);
    }
    @Test
    public void testConverterUtilitiesIstanceOfArrayList() {
        super.setFileName("test/CondTestLogicNotPresentTest.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        assertInstanceOf(psiClassBeans,ArrayList.class);
    }
}
