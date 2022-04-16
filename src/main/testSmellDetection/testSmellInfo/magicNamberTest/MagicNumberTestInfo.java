package main.testSmellDetection.testSmellInfo.magicNamberTest;

import main.testSmellDetection.bean.PsiClassBean;
import main.testSmellDetection.testSmellInfo.TestSmellInfo;

import java.util.ArrayList;

public class MagicNumberTestInfo extends TestSmellInfo {

  private ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber;

  public MagicNumberTestInfo(PsiClassBean clallWithSmell,ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber) {
    super(clallWithSmell);
    this.methodsThatCauseMagicNumber = methodsThatCauseMagicNumber;
  }

  public ArrayList<MethodWithMagicNumber> getMethodsThatCauseMagicNumber() {
    return methodsThatCauseMagicNumber;
  }

  public void setMethodsThatCauseMagicNumber(ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber) {
    this.methodsThatCauseMagicNumber = methodsThatCauseMagicNumber;
  }
}
