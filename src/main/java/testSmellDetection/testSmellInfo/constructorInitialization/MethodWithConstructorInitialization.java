package testSmellDetection.testSmellInfo.constructorInitialization;

import testSmellDetection.bean.PsiMethodBean;

public class MethodWithConstructorInitialization {

    private PsiMethodBean methodWithConstructorInitialization;

    public MethodWithConstructorInitialization(PsiMethodBean methodWithConstructorInitialization) {
        this.methodWithConstructorInitialization = methodWithConstructorInitialization;
    }

    public PsiMethodBean getMethodWithConstructorInitialization() {
        return methodWithConstructorInitialization;
    }

    public void setMethodWithConstructorInitialization(PsiMethodBean methodWithConstructorInitialization) {
        this.methodWithConstructorInitialization = methodWithConstructorInitialization;
    }
}
