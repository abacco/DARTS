package windowCommitConstruction.testSmellPanel;

import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.ExceptionHandlingInfo;
import testSmellDetection.testSmellInfo.ExceptionHandlingInfo.MethodWithExceptionHandling;
import windowCommitConstruction.ExceptionHandlingCP;
import windowCommitConstruction.general.RefactorWindow;
import windowCommitConstruction.general.listRenderer.CustomListRenderer2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class ExHSmellPanel extends JSplitPane implements ListSelectionListener {

    private JBList smellList;
    private JBPanel refactorPreviewPanel;

    ArrayList<String> methodsNames = new ArrayList<>();

    private ExceptionHandlingInfo exceptionHandlingInfo;
    private Project project;
    private ExceptionHandlingCP exceptionHandlingCP;
    DefaultListModel model;

    Dimension minimumSize = new Dimension(150, 100);

    public ExHSmellPanel(ExceptionHandlingInfo info, Project project, ExceptionHandlingCP cp){
        this.project = project;
        this.exceptionHandlingCP = cp;

        model = new DefaultListModel ();
        this.refactorPreviewPanel = new JBPanel();
        this.exceptionHandlingInfo = info;

        for(MethodWithExceptionHandling methodWithExceptionHandling : info.getMethodWithExceptionHandlings()){
            model.addElement(methodWithExceptionHandling.getMethodWithExceptionHandling().getName());
            methodsNames.add(methodWithExceptionHandling.getMethodWithExceptionHandling().getName());
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

    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList)e.getSource();
        updateRefactorPreviewLabel(list.getSelectedIndex());
    }

    //Renders the selected image
    protected void updateRefactorPreviewLabel (int index) {
        MethodWithExceptionHandling methodWithExceptionHandling;
        if(index == -1 && model.getSize() == 0){
            return;
        } else if(index == -1){
            methodWithExceptionHandling = exceptionHandlingInfo.getMethodWithExceptionHandlings().get(0);
        } else {
            methodWithExceptionHandling = exceptionHandlingInfo.getMethodWithExceptionHandlings().get(index);
        }
        RefactorWindow refactorWindow = new RefactorWindow(methodWithExceptionHandling, exceptionHandlingInfo, project, this);
        this.setRightComponent(refactorWindow.getRootPanel());
    }

    public void doAfterRefactor(){
        int index = smellList.getSelectedIndex();

        methodsNames.remove(index);
        exceptionHandlingInfo.getMethodWithExceptionHandlings().remove(index);
        model.remove(index);

        if(model.getSize() == 0){
            System.out.println("PASSO1");
            exceptionHandlingCP.doAfterRefactor();
        } else {
            if(index == model.getSize()){
                index --;
            }
            smellList.setSelectedIndex(index);
            smellList.ensureIndexIsVisible(index);
            updateRefactorPreviewLabel(smellList.getSelectedIndex());
        }
    }
}
