package main.testSmellDetection.testSmellInfo.magicNamberTest;

import main.testSmellDetection.bean.PsiMethodBean;

public class MethodWithMagicNumber {

  private PsiMethodBean methodBean;

  public MethodWithMagicNumber(PsiMethodBean methodBean){
    this.methodBean = methodBean;
  }

  public PsiMethodBean getMethodBean() {
    return methodBean;
  }

  public void setMethodBean(PsiMethodBean methodBean) {
    this.methodBean = methodBean;
  }
}
