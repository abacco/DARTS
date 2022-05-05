package testSmellDetection.testSmellInfo;

import testSmellDetection.bean.PsiClassBean;

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
