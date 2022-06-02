package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.ExceptionHandlingInfo;
import testSmellDetection.testSmellInfo.conditionalTestLogic.CondTestLogicInfo;
import testSmellDetection.testSmellInfo.constructorInitialization.ConstructorInitializationInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;
import windowCommitConstruction.CommitWindowFactory;
import org.jetbrains.annotations.NotNull;
import testSmellDetection.detector.IDetector;
import testSmellDetection.detector.TestSmellStructuralDetector;
import testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import java.util.ArrayList;

/**
 * Questa classe descrive la action per eseguire una analisi Strutturale sul progetto attualmente attivo
 */
public class StructuralDetectionAction extends AnAction {

    private static final int THRESHOLD_MN = 0;
    private static final int THRESHOLD_EH = 0;

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        IDetector detector = new TestSmellStructuralDetector(anActionEvent.getProject());
        ArrayList<GeneralFixtureInfo> generalFixtureInfos = detector.executeDetectionForGeneralFixture();
        ArrayList<EagerTestInfo> eagerTestInfos = detector.executeDetectionForEagerTest();
        ArrayList<LackOfCohesionInfo> lackOfCohesionInfos = detector.executeDetectionForLackOfCohesion();
        //Magic Number
        ArrayList<MagicNumberTestInfo> magicNumberTestInfos = detector.executeDetectionForMagicNumber();
        //Conditional Test Logic
        ArrayList<CondTestLogicInfo> condTestLogicInfos = detector.executeDetectionForCondTestLogic(THRESHOLD_MN);
        // ConstructorInitialization
        ArrayList<ConstructorInitializationInfo> constructorInitializationInfos = detector.executeDetectionForConstructorInitialization();
        // Exception Handling
        ArrayList<ExceptionHandlingInfo> exceptionHandlingInfos = detector.executeDetectionForExceptionHandling(THRESHOLD_EH);

        System.out.println("\n\n ########################### ACTION - DETECTOR STRUTTURALE: risultato dell'analisi. ###########################\n\n");
        for(GeneralFixtureInfo info : generalFixtureInfos){
            System.out.println("\n   GENERAL FIXTURE: " + info.toString());
        }
        for(EagerTestInfo info : eagerTestInfos){
            System.out.println("\n   EAGER TEST: " + info.toString());
        }
        for(LackOfCohesionInfo info : lackOfCohesionInfos){
            System.out.println("\n   LACK OF COHESION: " + info.toString());
        }
        //Magic Number
        for(MagicNumberTestInfo info : magicNumberTestInfos){
            System.out.println("\n   MAGIC NUMBER: " + info.toString());
        }
        //Conditional Test Logic
        for(CondTestLogicInfo info : condTestLogicInfos){
            System.out.println("\n   CONDITIONAL TEST LOGIC: " + info.toString());
        }
        // ConstructorInitialization
        for(ConstructorInitializationInfo info : constructorInitializationInfos){
            System.out.println("\n   CONSTRUCTOR INIT : " + info.toString());
        }
        // ExceptionHandling
        for(ExceptionHandlingInfo info : exceptionHandlingInfos){
            System.out.println("\n   EXCEPTION HANDLING : " + info.toString());
        }

        if(generalFixtureInfos.isEmpty() && eagerTestInfos.isEmpty() && lackOfCohesionInfos.isEmpty() &&
                magicNumberTestInfos.isEmpty() &&
                condTestLogicInfos.isEmpty() &&
                exceptionHandlingInfos.isEmpty() &&
                constructorInitializationInfos.isEmpty()){
            System.out.println("\n Non si è trovato alcuno Smell");
        } else {
            //TestSmellWindowFactory.createWindow(false, true, anActionEvent.getProject(), generalFixtureInfos, eagerTestInfos, lackOfCohesionInfos);
            CommitWindowFactory.createWindow(false, true, anActionEvent.getProject(),
                    generalFixtureInfos,
                    eagerTestInfos,
                    lackOfCohesionInfos,
                    magicNumberTestInfos,
                    condTestLogicInfos,
                    constructorInitializationInfos,
                    exceptionHandlingInfos);
        }
    }

}
