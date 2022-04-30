package testSmellDetection.testSmellInfo.constructorInitialization;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.TestSmellInfo;

import java.util.ArrayList;

public class ConstructorInitializationInfo extends TestSmellInfo {

    private ArrayList<MethodWithConstructorInitialization> methodWithConstructorInitializationArrayList;

    public ConstructorInitializationInfo(PsiClassBean classWithSmell, ArrayList<MethodWithConstructorInitialization> methodWithConstructorInitializationArrayList) {
        super(classWithSmell);
        this.methodWithConstructorInitializationArrayList = methodWithConstructorInitializationArrayList;
    }

    public ArrayList<MethodWithConstructorInitialization> getMethodWithConstructorInitializationArrayList() {
        return methodWithConstructorInitializationArrayList;
    }

    public void setMethodWithConstructorInitializationArrayList(ArrayList<MethodWithConstructorInitialization> methodWithConstructorInitializationArrayList) {
        this.methodWithConstructorInitializationArrayList = methodWithConstructorInitializationArrayList;
    }

    public PsiClassBean getClassWithMagicNumber() {
        return classWithSmell;
    }

    @Override
    public String toString() {
        return "ConstructorInitializationInfo{" +
                "classWithSmell=" + classWithSmell +
                ", methodWithConstructorInitializationArrayList=" + methodWithConstructorInitializationArrayList +
                '}';
    }
}
