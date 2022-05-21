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
        ArrayList<MethodWithExceptionHandling> methodsWithExceptHandling = new ArrayList<>();
        int count = 0;
        for(PsiMethodBean method : testClass.getPsiMethodBeans()) {

            PsiCodeBlock body = method.getPsiMethod().getBody();

            if (body == null) {
                return null;
            }
            final PsiStatement[] statements = body.getStatements();
            ArrayList<PsiStatement> arrayList1 = new ArrayList<>();
            for(PsiStatement statement : statements){
                arrayList1.add(0, statement);
                if(statement instanceof PsiTryStatement || statement instanceof PsiThrowStatement){
                    count++;
                }
            }
            if(count > threshold){
                methodsWithExceptHandling.add(0, new MethodWithExceptionHandling(method));
            }
        }
        if (methodsWithExceptHandling.isEmpty()){
            return null;
        } else{
            return methodsWithExceptHandling;
        }
    }
}
