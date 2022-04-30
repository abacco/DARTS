package testSmellDetection.textualRules;

import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.testSmellInfo.constructorInitialization.MethodWithConstructorInitialization;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;

import java.util.ArrayList;

public abstract class ConstructorInitTextual {

    public static boolean isMagicNumber(PsiClassBean testClass){return false;}


    public static ArrayList<MethodWithConstructorInitialization> checkMethodsThatCauseMagicNumber(PsiClassBean testClass){
        return null;
    }
}
