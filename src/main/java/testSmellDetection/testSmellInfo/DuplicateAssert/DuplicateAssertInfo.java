package testSmellDetection.testSmellInfo.DuplicateAssert;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.TestSmellInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;

import java.util.ArrayList;

public class DuplicateAssertInfo extends TestSmellInfo {
    private ArrayList<MethodWithDuplicateAssert> methodsThatCauseDuplicateAssert;

    public DuplicateAssertInfo(PsiClassBean classWithSmell,
                               ArrayList<MethodWithDuplicateAssert> methodsThatCauseMagicNumber) {
        super(classWithSmell);
        this.methodsThatCauseDuplicateAssert = methodsThatCauseMagicNumber;
    }


    @Override
    public String toString() {
        return "DuplicateAssertInfo{" +
                "classWithDuplicateAssert=" + classWithSmell +
                ", methodsThatCauseDuplicateAssert=" + methodsThatCauseDuplicateAssert +
                '}';
    }

    /* GETTER & SETTER */

    public ArrayList<MethodWithDuplicateAssert> getMethodsThatCauseDuplicateAssert() {
        return methodsThatCauseDuplicateAssert;
    }

    public void setMethodsThatCauseDuplicateAssert(ArrayList<MethodWithDuplicateAssert> methodsThatCauseDuplicateAssert) {
        this.methodsThatCauseDuplicateAssert = methodsThatCauseDuplicateAssert;
    }
}
