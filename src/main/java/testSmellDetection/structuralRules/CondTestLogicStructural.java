package testSmellDetection.structuralRules;

import com.intellij.psi.*;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import java.util.ArrayList;

public abstract class CondTestLogicStructural {

    public static ArrayList<MethodWithCondTestLogic> checkMethodsThatCauseCondTestLogic(PsiClassBean testClass, int threshold){
        if(threshold<0 || threshold>5)
            return null;
        ArrayList<MethodWithCondTestLogic> methodsWithCondTestLogics = new ArrayList<>();
        int count = 0;
        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            PsiStatement[] psiStatements = psiMethodBeanInside.getPsiMethod().getBody().getStatements();
            if(psiStatements != null && psiStatements.length!=0){
                for(int i=psiStatements.length-1; i>=0; i--){
                    if(psiStatements[i] instanceof PsiIfStatement){
                        count++;
                    }
                    if(psiStatements[i] instanceof PsiSwitchStatement){
                        count++;
                    }
                    if(psiStatements[i] instanceof PsiConditionalLoopStatement){
                        count++;
                    }
                }
                if(count > threshold){
                    methodsWithCondTestLogics.add(new MethodWithCondTestLogic(psiMethodBeanInside));
                }
                count = 0;
            }
        }
        if(methodsWithCondTestLogics.isEmpty()){
            return null;
        } else {
            return methodsWithCondTestLogics;
        }
    }
}
