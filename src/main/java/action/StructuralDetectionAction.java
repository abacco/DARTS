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

import javax.swing.*;
import java.util.ArrayList;

/**
 * Questa classe descrive la action per eseguire una analisi Strutturale sul progetto attualmente attivo
 */
public class StructuralDetectionAction extends AnAction {

    private static  int THRESHOLD_MN = 0;
    private static  int THRESHOLD_EH = 0;

    private ThresholdPanel thresholdPanel;

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        thresholdPanel = new ThresholdPanel(anActionEvent.getProject());
        thresholdPanel.setListener(thresholdPanel.getEnterButton());

    }
}
