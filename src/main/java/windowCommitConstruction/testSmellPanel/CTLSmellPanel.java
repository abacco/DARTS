package windowCommitConstruction.testSmellPanel;

import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;
import testSmellDetection.testSmellInfo.conditionalTestLogic.CondTestLogicInfo;
import testSmellDetection.testSmellInfo.conditionalTestLogic.MethodWithCondTestLogic;
import testSmellDetection.testSmellInfo.magicNamberTest.MagicNumberTestInfo;
import testSmellDetection.testSmellInfo.magicNamberTest.MethodWithMagicNumber;
import windowCommitConstruction.CondTestLogicCP;
import windowCommitConstruction.MagicNumberCP;
import windowCommitConstruction.general.RefactorWindow;
import windowCommitConstruction.general.listRenderer.CustomListRenderer2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class CTLSmellPanel  extends JSplitPane implements ListSelectionListener {

    private JBList smellList;
    private JBPanel refactorPreviewPanel;

    ArrayList<String> methodsNames = new ArrayList<>();

    private CondTestLogicInfo condTestLogicInfo;
    private Project project;
    private CondTestLogicCP condTestLogicCP;
    DefaultListModel model;

    Dimension minimumSize = new Dimension(150, 100);

    public CTLSmellPanel(CondTestLogicInfo condTestLogicInfo, Project project, CondTestLogicCP condTestLogicCP){
        this.project = project;
        this.condTestLogicCP = condTestLogicCP;

        model = new DefaultListModel ();

        this.refactorPreviewPanel = new JBPanel();
        this.condTestLogicInfo = condTestLogicInfo;

        for(MethodWithCondTestLogic methodWithCondTestLogic : condTestLogicInfo.getMethodsThatCauseCondTestLogics()){
            model.addElement(methodWithCondTestLogic.getMethodWithCondTestLogic().getName());
            methodsNames.add(methodWithCondTestLogic.getMethodWithCondTestLogic().getName());
        }

        smellList = new JBList(model);
        smellList.setCellRenderer( new CustomListRenderer2(smellList));

        smellList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        smellList.setSelectedIndex(0);
        smellList.addListSelectionListener(this);
        JBScrollPane smellScrollPane = new JBScrollPane(smellList);
        smellScrollPane.setBorder(new TitledBorder("METHODS"));

        // Creazione dello split pane con la lista degli smell e la preview del refactoring.
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setLeftComponent(smellScrollPane);
        this.setOneTouchExpandable(true);
        this.setDividerLocation(150);

        // Fornisco le dimensioni minime dei due panel e una dimensione di base per l'intero panel.
        smellScrollPane.setMinimumSize(minimumSize);
        refactorPreviewPanel.setMinimumSize(minimumSize);
        this.setPreferredSize(new Dimension(400, 200));

        // Starto il secondo panel per la prima volta.
        updateRefactorPreviewLabel(smellList.getSelectedIndex());
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList)e.getSource();
        updateRefactorPreviewLabel(list.getSelectedIndex());
    }

    //Renders the selected image
    protected void updateRefactorPreviewLabel (int index) {
        MethodWithCondTestLogic methodWithCTL;
        if(index == -1 && model.getSize() == 0){
            return;
        } else if(index == -1){
            methodWithCTL = condTestLogicInfo.getMethodsThatCauseCondTestLogics().get(0);
        } else {
            methodWithCTL = condTestLogicInfo.getMethodsThatCauseCondTestLogics().get(index);
        }
        RefactorWindow refactorWindow = new RefactorWindow(methodWithCTL, condTestLogicInfo, project, this);
        this.setRightComponent(refactorWindow.getRootPanel());
    }

}
