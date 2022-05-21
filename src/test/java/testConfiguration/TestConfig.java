package testConfiguration;

import com.intellij.testFramework.fixtures.*;

public class TestConfig extends LightJavaCodeInsightFixtureTestCase {

    public void setFileName(String fileName){
        myFixture.configureByFile(fileName);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testdata/";
    }
}
