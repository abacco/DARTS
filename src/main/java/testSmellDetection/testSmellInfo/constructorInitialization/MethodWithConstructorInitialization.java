package testSmellDetection.testSmellInfo.constructorInitialization;

import testSmellDetection.bean.PsiMethodBean;

public class MethodWithConstructorInitialization {

    private PsiMethodBean methodWithMagicNumber;

    public MethodWithConstructorInitialization(PsiMethodBean methodWithMagicNumber) {
        this.methodWithMagicNumber = methodWithMagicNumber;
    }

    public PsiMethodBean getMethodWithMagicNumber() {
        return methodWithMagicNumber;
    }

    public void setMethodWithMagicNumber(PsiMethodBean methodWithMagicNumber) {
        this.methodWithMagicNumber = methodWithMagicNumber;
    }
}
