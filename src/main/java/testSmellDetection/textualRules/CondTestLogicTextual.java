package testSmellDetection.textualRules;

import com.intellij.psi.*;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import java.util.ArrayList;

public abstract class CondTestLogicTextual {

    public static ArrayList<MethodWithCondTestLogic> checkMethodsThatCauseCondTestLogic(PsiClassBean testClass){
        ArrayList<MethodWithCondTestLogic> methodsWithCondTestLogics = new ArrayList<>();
        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            PsiStatement[] psiStatements = psiMethodBeanInside.getPsiMethod().getBody().getStatements();
            if(psiStatements != null && psiStatements.length!=0){
                for(int i=psiStatements.length-1; i>=0; i--){
                    if(psiStatements[i] instanceof PsiIfStatement){
                        methodsWithCondTestLogics.add(new MethodWithCondTestLogic(psiMethodBeanInside));
                    }
                    if(psiStatements[i] instanceof PsiSwitchStatement){
                        methodsWithCondTestLogics.add(new MethodWithCondTestLogic(psiMethodBeanInside));
                    }
                    if(psiStatements[i] instanceof PsiConditionalLoopStatement){
                        methodsWithCondTestLogics.add(new MethodWithCondTestLogic(psiMethodBeanInside));
                    }
                }
            }
        }
        if(methodsWithCondTestLogics.isEmpty()){
            return null;
        } else {
            return methodsWithCondTestLogics;
        }
    }
}
