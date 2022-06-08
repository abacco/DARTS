package testSmellDetection.structuralRules;

import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiMethodCallExpression;
import org.jetbrains.annotations.NotNull;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.IgnoredTest.MethodWithIgnoredTest;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class IgnoredTestStructural {
    /**
     * Questo metodo verifica se una classe è affetta da Ignored Test o meno.
     *
     * @param testClass la classe da analizzare.
     * @return vero se la classe è smelly, falso altrimenti.
     */
    public static boolean IgnoredTestMethods(PsiClassBean testClass) {
        for (PsiMethodBean testMethod : testClass.getPsiMethodBeans()) {
            String methodText = null;
            //Aggiungo la stringa di controllo al testo del metodo
            methodText.equals("@Ignored");
            if (methodText == "true") {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static ArrayList<MethodWithIgnoredTest> checkMethodsThatIgnoredTest(PsiClassBean testClass) {
        ArrayList<MethodWithIgnoredTest> methodWithIgnoredTests = new ArrayList<>();
        for(PsiMethodBean psiMethodBeanInside : testClass.getPsiMethodBeans()){
            String methodName = psiMethodBeanInside.getPsiMethod().getName();
            if(!methodName.equals(testClass.getPsiClass().getName()) &&
                    !methodName.toLowerCase().equals("setup") &&
                    !methodName.toLowerCase().equals("teardown")) {
                /*if (psiMethodBeanInside.getPsiMethod().getAnnotation("Ignored")!= null){
                    methodWithIgnoredTests.add(new MethodWithIgnoredTest(psiMethodBeanInside));
                }*/
                if(psiMethodBeanInside.getPsiClass().getAnnotation("@Ignore") != null) {
                    methodWithIgnoredTests.add(new MethodWithIgnoredTest(psiMethodBeanInside));
                }
            }
        }
        if(methodWithIgnoredTests.isEmpty()){
            return new ArrayList<>();
        } else {
            return methodWithIgnoredTests;
        }
    }
}
