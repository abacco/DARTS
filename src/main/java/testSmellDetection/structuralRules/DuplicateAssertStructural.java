package testSmellDetection.structuralRules;

import com.intellij.psi.PsiMethodCallExpression;
import com.intellij.psi.PsiStatement;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.DuplicateAssert.MethodWithDuplicateAssert;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class DuplicateAssertStructural {

    public static ArrayList<MethodWithDuplicateAssert> checkMethodsThatCauseDuplicateAssert(PsiClassBean testClass) {
        ArrayList<MethodWithDuplicateAssert> methodsWithDuplicateAsserts = new ArrayList<>();
        int counter = 0;
        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            String methodName = psiMethodBeanInside.getPsiMethod().getName();
            if(!methodName.equals(testClass.getPsiClass().getName()) &&
                    !methodName.toLowerCase().equals("setup") &&
                    !methodName.toLowerCase().equals("teardown")){
                ArrayList<PsiMethodCallExpression> methodCalls = psiMethodBeanInside.getMethodCalls();
                if(methodCalls.size() >= 1){
                    for(PsiMethodCallExpression callExpression : methodCalls){
                        /*Prendo il nome del metodo */
                        String methodCallName = callExpression.getMethodExpression().getQualifiedName();
                        if(methodCallName.toLowerCase().contains("assert")){
                            counter++;
                        }
                    }
                    if (counter>1){
                        methodsWithDuplicateAsserts.add(new MethodWithDuplicateAssert(psiMethodBeanInside));
                    }
                }
            }
            counter=0;
        }
        if (methodsWithDuplicateAsserts.isEmpty()) {
            return null;
        } else {
            return methodsWithDuplicateAsserts;
        }
    }

}