package testSmellDetection.textualRules;

import com.intellij.psi.PsiCodeBlock;
import com.intellij.psi.PsiStatement;
import com.intellij.psi.PsiThrowStatement;
import com.intellij.psi.PsiTryStatement;
import org.jetbrains.annotations.NotNull;
import testSmellDetection.bean.PsiClassBean;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.MethodWithExceptionHandling;

import java.util.ArrayList;

public abstract class ExceptionHandlingTextual {

/*    public static boolean checkMethodsThatContainExceptions(@NotNull PsiClassBean testClass) {
        ArrayList<PsiMethodBean> arrayList = testClass.getPsiMethodBeans();
        for(PsiMethodBean method : arrayList) {

            PsiCodeBlock body = method.getPsiMethod().getBody();

            if (body == null) {
                return false;
            }
            final PsiStatement[] statements = body.getStatements();
            ArrayList<PsiStatement> arrayList1 = new ArrayList<>();
            for(PsiStatement statement : statements){
                arrayList1.add(0, statement);
                if(statement.getText().contains("try")){
                    return true;
                }
            }
        }
        return false;
    }*/

    public static ArrayList<MethodWithExceptionHandling> checkMethodsThatContainExceptions(@NotNull PsiClassBean testClass) {
        ArrayList<MethodWithExceptionHandling> arrayList = new ArrayList<>();

        for(PsiMethodBean method : testClass.getPsiMethodBeans()) {

            PsiCodeBlock body = method.getPsiMethod().getBody();

            if (body == null) {
                return null;
            }
            final PsiStatement[] statements = body.getStatements();
            ArrayList<PsiStatement> arrayList1 = new ArrayList<>();
            for(PsiStatement statement : statements){
                arrayList1.add(0, statement);
                if(statement instanceof PsiTryStatement || statement instanceof PsiThrowStatement){
                    arrayList.add(0, new MethodWithExceptionHandling(method));
                }
            }
        }
        if (arrayList.isEmpty()){
            return null;
        } else{
            return arrayList;
        }
    }
}
