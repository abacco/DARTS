package testSmellDetection.textualRules;

import com.intellij.psi.PsiMethodCallExpression;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.constructorInitialization.MethodWithConstructorInitialization;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;

import java.util.ArrayList;

public abstract class ConstructorInitTextual {

    public static boolean isMagicNumber(PsiClassBean testClass){//Dalla classe di test prendo tutti i metodi
        ArrayList<PsiMethodBean> methods = testClass.getPsiMethodBeans();
        //Per ogni metodo controllo quali chiamate fa
        for (PsiMethodBean methodBean : methods){
            ArrayList<PsiMethodCallExpression> methodCall = methodBean.getMethodCalls();
        }
        return false;
    }

// The test class utilizes a constructor instead of a setUp method to initialize fields.
    public static ArrayList<MethodWithConstructorInitialization> checkMethodsThatCauseMagicNumber(PsiClassBean testClass){
        ArrayList<MethodWithConstructorInitialization> methodWithConstructorInitializationArrayList = new ArrayList<>();

        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            String methodName = psiMethodBeanInside.getPsiMethod().getName();
            if(!methodName.equals(testClass.getPsiClass().getName()) &&
                    !methodName.toLowerCase().equals("setup") && // != da setup
                    !methodName.toLowerCase().equals("teardown")){
                ArrayList<PsiMethodCallExpression> methodCalls = psiMethodBeanInside.getMethodCalls();
                if(methodCalls.size() >= 1){
                    for(PsiMethodCallExpression callExpression : methodCalls){
                        /*Prendo il nome del metodo */
                        String methodCallName = callExpression.getMethodExpression().getQualifiedName();
                        if(methodCallName.equals(testClass.getName())){
                            methodWithConstructorInitializationArrayList.add(new MethodWithConstructorInitialization(psiMethodBeanInside));
                        }
                    }
                }
            }
        }
        if(methodWithConstructorInitializationArrayList.isEmpty()){
            return null;
        } else {
            return methodWithConstructorInitializationArrayList;
        }
    }
}
