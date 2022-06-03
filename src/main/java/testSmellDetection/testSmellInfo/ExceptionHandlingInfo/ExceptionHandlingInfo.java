package testSmellDetection.testSmellInfo.ExceptionHandlingInfo;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.TestSmellInfo;

import java.util.ArrayList;

public class ExceptionHandlingInfo extends TestSmellInfo {

    private ArrayList<MethodWithExceptionHandling> methodWithExceptionHandlings;

    public ExceptionHandlingInfo(PsiClassBean classWithSmell,
                                 ArrayList<MethodWithExceptionHandling> methodWithExceptionHandlings) {
        super(classWithSmell);
        this.methodWithExceptionHandlings = methodWithExceptionHandlings;
    }


    public ArrayList<MethodWithExceptionHandling> getMethodWithExceptionHandlings() {
        return methodWithExceptionHandlings;
    }

    public void setMethodWithExceptionHandlings(ArrayList<MethodWithExceptionHandling> methodWithExceptionHandlings) {
        this.methodWithExceptionHandlings = methodWithExceptionHandlings;
    }

    @Override
    public String toString() {
        return "ExceptionHandlingInfo{" +
                "methodWithExceptionHandlings=" + methodWithExceptionHandlings +
                ", classWithSmell=" + classWithSmell +
                '}';
    }
}
