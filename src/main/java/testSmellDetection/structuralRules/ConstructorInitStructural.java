package testSmellDetection.structuralRules;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.constructorInitialization.MethodWithConstructorInitialization;

import java.util.ArrayList;

public abstract class ConstructorInitStructural {

    public static ArrayList<MethodWithConstructorInitialization> checkMethodsThatCauseConstructorInitialization(PsiClassBean testClass){
        ArrayList<MethodWithConstructorInitialization> methodWithConstructorInitializationArrayList = new ArrayList<>();
        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            String methodName = psiMethodBeanInside.getPsiMethod().getName();
            if(methodName.equals(testClass.getPsiClass().getName())) {
               methodWithConstructorInitializationArrayList.add(0, new MethodWithConstructorInitialization(psiMethodBeanInside));
            }
        }
        if(methodWithConstructorInitializationArrayList.isEmpty()){
            return null;
        } else {
            return methodWithConstructorInitializationArrayList;
        }
    }
}
