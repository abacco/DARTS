package main.testSmellDetection.textualRules;

import com.intellij.psi.PsiMethodCallExpression;
import main.testSmellDetection.bean.PsiClassBean;
import main.testSmellDetection.bean.PsiMethodBean;

import java.util.ArrayList;

public abstract class MagicNumberTextual {
  public static boolean isMagicNumber(PsiClassBean testClass){
    //Dalla classe di test prendo tutti i metodi
    ArrayList<PsiMethodBean> methods = testClass.getPsiMethodBeans();
    //Per ogni metodo controllo quali chiamate fa
    for (PsiMethodBean methodBean : methods){
      ArrayList<PsiMethodCallExpression> methodCall = methodBean.getMethodCalls();
    }
    return false;
  }
}
