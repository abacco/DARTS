package testSmellDetection.structuralRules;

import com.intellij.psi.PsiMethodCallExpression;
import com.intellij.psi.PsiStatement;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.DuplicateAssert.MethodWithDuplicateAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class DuplicateAssertStructural {

    public static ArrayList<MethodWithDuplicateAssert> checkMethodsThatCauseDuplicateAssert(PsiClassBean testClass) {
        ArrayList<MethodWithDuplicateAssert> methodsWithDuplicateAsserts = new ArrayList<>();
        int counter = 0;
        for (PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()) {
            String methodName = psiMethodBeanInside.getPsiMethod().getName();
            if (!methodName.equals(testClass.getPsiClass().getName()) &&
                    !methodName.toLowerCase().equals("setup") &&
                    !methodName.toLowerCase().equals("teardown")) {

                if(Arrays.toString(Objects.requireNonNull(psiMethodBeanInside.getPsiMethod().getBody()).getStatements()).contains("assert")){
                    counter++;
                    if(counter > 1){
                        methodsWithDuplicateAsserts.add(0, new MethodWithDuplicateAssert(psiMethodBeanInside));
                    }
                }
                /*for(PsiStatement stmt : psiMethodBeanInside.getPsiMethod().getBody().getStatements()){
                    if (stmt.getText().contains("assert")){
                        counter++;
                        if(counter > 1){
                            methodsWithDuplicateAsserts.add(0, new MethodWithDuplicateAssert(psiMethodBeanInside));
                        }
                    }
                }*/
            }
            if (methodsWithDuplicateAsserts.isEmpty()) {
                return new ArrayList<>();
            } else {
                return methodsWithDuplicateAsserts;
            }
        }
        return null;
    }
}

