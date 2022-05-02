package testSmellDetection.testSmellInfo.ExceptionHandlingInfo;

import testSmellDetection.bean.PsiMethodBean;

public class MethodWithExceptionHandling {

    private PsiMethodBean methodWithExceptionHandling;

    public MethodWithExceptionHandling(PsiMethodBean methodWithExceptionHandling) {
        this.methodWithExceptionHandling = methodWithExceptionHandling;
    }

    public PsiMethodBean getMethodWithExceptionHandling() {
        return methodWithExceptionHandling;
    }

    public void setMethodWithExceptionHandling(PsiMethodBean methodWithExceptionHandling) {
        this.methodWithExceptionHandling = methodWithExceptionHandling;
    }

}
