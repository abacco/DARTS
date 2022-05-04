package testSmellDetection.testSmellInfo.conditionalTestLogic;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.TestSmellInfo;

import java.util.ArrayList;

public class CondTestLogicInfo extends TestSmellInfo {

    private ArrayList<MethodWithCondTestLogic> methodsThatCauseCondTestLogics;

    public CondTestLogicInfo(PsiClassBean classWithSmell, ArrayList<MethodWithCondTestLogic> methodsThatCauseCondTestLogics) {
        super(classWithSmell);
        this.methodsThatCauseCondTestLogics = methodsThatCauseCondTestLogics;
    }

    @Override
    public String toString() {
        return "ConditionalTestLogicInfo{" +
                "classWithGeneralFixture=" + classWithSmell +
                ", methodsThatCauseGeneralFixture=" + methodsThatCauseCondTestLogics +
                '}';
    }

    /* GETTER & SETTER */

    public ArrayList<MethodWithCondTestLogic> getMethodsThatCauseCondTestLogics() {
        return methodsThatCauseCondTestLogics;
    }

    public void setMethodsThatCauseCondTestLogics(ArrayList<MethodWithCondTestLogic> methodsThatCauseCondTestLogics) {
        this.methodsThatCauseCondTestLogics = methodsThatCauseCondTestLogics;
    }

    public PsiClassBean getClassWithCondTestLogic() {
        return classWithSmell;
    }

    public void setClassWithCondTestLogic(PsiClassBean classWithMagicNumber) {
        this.classWithSmell = classWithMagicNumber;
    }
}
