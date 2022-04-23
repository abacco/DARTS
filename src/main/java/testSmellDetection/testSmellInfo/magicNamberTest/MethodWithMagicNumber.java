package testSmellDetection.testSmellInfo.magicNamberTest;

import testSmellDetection.bean.PsiMethodBean;

public class MethodWithMagicNumber {

  private PsiMethodBean methodWithMagicNumber;

  public MethodWithMagicNumber(PsiMethodBean methodWithMagicNumber){
    this.methodWithMagicNumber = methodWithMagicNumber;
  }

  /* GETTER & SETTER */

  public PsiMethodBean getMethodWithMagicNumber() {
    return methodWithMagicNumber;
  }

  public void setMethodWithMagicNumber(PsiMethodBean methodWithMagicNumber) {
    this.methodWithMagicNumber = methodWithMagicNumber;
  }
}
