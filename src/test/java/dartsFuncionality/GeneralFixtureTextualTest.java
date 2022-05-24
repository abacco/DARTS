package dartsFuncionality;

import org.junit.Test;
import testConfiguration.TestConfig;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.generalFixture.MethodWithGeneralFixture;
import testSmellDetection.textualRules.GeneralFixtureTextual;
import utility.ConverterUtilities;

import java.util.ArrayList;

public class GeneralFixtureTextualTest extends TestConfig {

    @Test
    public void testGeneralFixtureNotPresent() {
        super.setFileName("test/GeneralFixtureNotPresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<MethodWithGeneralFixture> smellList = GeneralFixtureTextual.checkMethodsThatCauseGeneralFixture(psiClassBeans.get(0));
        assertEquals(null, smellList);
    }

    @Test
    public void testGeneralFixturePresent() {
        super.setFileName("test/GeneralFixturePresent.java");
        ArrayList<PsiClassBean> psiClassBeans = ConverterUtilities.getClassesFromPackages(getProject());
        ArrayList<MethodWithGeneralFixture> smellList = GeneralFixtureTextual.checkMethodsThatCauseGeneralFixture(psiClassBeans.get(0));
        assertEquals(1, smellList.size());
    }

}
