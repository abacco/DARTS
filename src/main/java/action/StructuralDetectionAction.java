package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Questa classe descrive la action per eseguire una analisi Strutturale sul progetto attualmente attivo
 */
public class StructuralDetectionAction extends AnAction {
    
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        ThresholdPanelStructural thresholdPanelStructural = new ThresholdPanelStructural(anActionEvent.getProject());
        thresholdPanelStructural.setListener(thresholdPanelStructural.getEnterButton());

    }
}
