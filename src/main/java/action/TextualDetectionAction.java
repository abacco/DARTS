package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import testSmellDetection.testSmellInfo.DuplicateAssert.DuplicateAssertInfo;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.ExceptionHandlingInfo;
import testSmellDetection.testSmellInfo.IgnoredTest.IgnoredTestInfo;
import testSmellDetection.testSmellInfo.conditionalTestLogic.CondTestLogicInfo;
import testSmellDetection.testSmellInfo.constructorInitialization.ConstructorInitializationInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;
import windowCommitConstruction.CommitWindowFactory;
import org.jetbrains.annotations.NotNull;

import testSmellDetection.detector.IDetector;
import testSmellDetection.detector.TestSmellTextualDetector;
import testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import java.util.*;

/**
 * Questa classe descrive la action per eseguire una analisi Strutturale sul progetto attualmente attivo
 */
public class TextualDetectionAction extends AnAction {

    private static final int THRESHOLD_MN = 0;
    private static final int THRESHOLD_EH = 0;

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        IDetector detector = new TestSmellTextualDetector(anActionEvent.getProject());
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
        // Duplicate Assert
        ArrayList<DuplicateAssertInfo> duplicateAssertInfos = detector.executeDetectionForDuplicateAssertInfo();
        //Ignored Test
        ArrayList<IgnoredTestInfo> ignoredTestInfos = detector.executeDetectionForIgnoredTestInfo();

        if(generalFixtureInfos.isEmpty() && eagerTestInfos.isEmpty() && lackOfCohesionInfos.isEmpty() &&
        magicNumberTestInfos.isEmpty() &&
        condTestLogicInfos.isEmpty() &&
        exceptionHandlingInfos.isEmpty() &&
        constructorInitializationInfos.isEmpty()){
            System.out.println("\n Non si è trovato alcuno Smell");
        } else {
            //TestSmellWindowFactory.createWindow(true, false, anActionEvent.getProject(), generalFixtureInfos, eagerTestInfos, lackOfCohesionInfos);
            //CommitWindowFactory.createWindow(true, false, anActionEvent.getProject(), generalFixtureInfos, eagerTestInfos, lackOfCohesionInfos);
            CommitWindowFactory.createWindow(true, false,anActionEvent.getProject(),
                    generalFixtureInfos,
                    eagerTestInfos,
                    lackOfCohesionInfos,
                    magicNumberTestInfos,
                    condTestLogicInfos,
                    constructorInitializationInfos,
                    exceptionHandlingInfos,
                    duplicateAssertInfos,
                    ignoredTestInfos);

        }
    }

}
