package testSmellDetection.textualRules;

import com.intellij.psi.PsiMethodCallExpression;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;
import java.util.ArrayList;

public abstract class MagicNumberTextual {

  public static ArrayList<MethodWithMagicNumber> checkMethodsThatCauseMagicNumber(PsiClassBean testClass){
    ArrayList<MethodWithMagicNumber> methodsWithMagicNumbers = new ArrayList<>();
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
            if(methodCallName.toLowerCase().contains("assertequal") ||
                    methodCallName.toLowerCase().contains("assert") ||
                    methodCallName.toLowerCase().contains("assertnotequals")){
              /*Prendo il primo argomento (expected) dall'assert */
              String firtsArg = callExpression.getArgumentList().getExpressions()[0].getText();
              if(firtsArg.matches("[0-9]+")){
                methodsWithMagicNumbers.add(new MethodWithMagicNumber(psiMethodBeanInside));
              }
            }
          }
        }
      }
    }
    if(methodsWithMagicNumbers.isEmpty()){
      return null;
    } else {
      return methodsWithMagicNumbers;
    }
  }
}