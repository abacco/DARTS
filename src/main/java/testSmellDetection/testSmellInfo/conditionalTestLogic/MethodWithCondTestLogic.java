package testSmellDetection.testSmellInfo.conditionalTestLogic;

import testSmellDetection.bean.PsiMethodBean;

public class MethodWithCondTestLogic {

    private PsiMethodBean methodWithMagicNumber;

    public MethodWithCondTestLogic(PsiMethodBean methodWithMagicNumber) {
        this.methodWithMagicNumber = methodWithMagicNumber;
    }

    /* GETTER & SETTER */

    public PsiMethodBean getMethodWithMagicNumber() {
        return methodWithMagicNumber;
    }

    public void setMethodWithMagicNumber(PsiMethodBean methodWithMagicNumber) {
        this.methodWithMagicNumber = methodWithMagicNumber;
    }
}
