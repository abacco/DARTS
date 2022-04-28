package testSmellDetection.testSmellInfo.magicNamberTest;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.TestSmellInfo;

import java.util.ArrayList;

public class MagicNumberTestInfo extends TestSmellInfo {

  private ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber;

  public MagicNumberTestInfo(PsiClassBean classWithMagicNumber,ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber) {
    super(classWithMagicNumber);
    this.methodsThatCauseMagicNumber = methodsThatCauseMagicNumber;
  }

  @Override
  public String toString() {
    return "GeneralFixtureInfo{" +
            "classWithGeneralFixture=" + classWithSmell +
            ", methodsThatCauseGeneralFixture=" + methodsThatCauseMagicNumber +
            '}';
  }

  /* GETTER & SETTER */

  public ArrayList<MethodWithMagicNumber> getMethodsThatCauseMagicNumber() {
    return methodsThatCauseMagicNumber;
  }

  public void setMethodsThatCauseMagicNumber(ArrayList<MethodWithMagicNumber> methodsThatCauseMagicNumber) {
    this.methodsThatCauseMagicNumber = methodsThatCauseMagicNumber;
  }

  public PsiClassBean getClassWithMagicNumber() {
    return classWithSmell;
  }

  public void setClassWithMagicNumber(PsiClassBean classWithMagicNumber) {
    this.classWithSmell = classWithMagicNumber;
  }
}
