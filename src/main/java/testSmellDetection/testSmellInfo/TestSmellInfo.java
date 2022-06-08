package testSmellDetection.testSmellInfo;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;

public class TestSmellInfo {
    protected PsiClassBean classWithSmell;

    public TestSmellInfo(PsiClassBean classWithSmell) {
        this.classWithSmell = classWithSmell;
    }

    public PsiClassBean getClassWithSmell() {
        return classWithSmell;
    }

    public void setClassWithSmell(PsiClassBean classWithSmell) {
        this.classWithSmell = classWithSmell;
    }

}
