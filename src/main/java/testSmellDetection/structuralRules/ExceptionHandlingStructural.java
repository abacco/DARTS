package testSmellDetection.structuralRules;

import com.intellij.psi.PsiCodeBlock;
import com.intellij.psi.PsiStatement;
import com.intellij.psi.PsiThrowStatement;
import com.intellij.psi.PsiTryStatement;
import org.jetbrains.annotations.NotNull;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.MethodWithExceptionHandling;

import java.util.ArrayList;

public abstract class ExceptionHandlingStructural {

    public static ArrayList<MethodWithExceptionHandling> checkMethodsThatContainExceptions(@NotNull PsiClassBean testClass, int threshold) {
        if(threshold<0 || threshold>5)
            return null;
        ArrayList<MethodWithExceptionHandling> methodsWithExceptHandling = new ArrayList<>();
        int count = 0;
        for(PsiMethodBean method : testClass.getPsiMethodBeans()) {
            PsiCodeBlock body = method.getPsiMethod().getBody();
            final PsiStatement[] statements = body.getStatements();
            for(PsiStatement statement : statements){
                if(statement instanceof PsiTryStatement || statement instanceof PsiThrowStatement){
                    count++;
                }
            }
            if(count > threshold){
                methodsWithExceptHandling.add(new MethodWithExceptionHandling(method));
            }
            count = 0;
        }
        if (methodsWithExceptHandling.isEmpty()){
            return null;
        } else{
            return methodsWithExceptHandling;
        }
    }
}
