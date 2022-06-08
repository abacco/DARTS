package windowCommitConstruction.testSmellPanel;

import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;
import testSmellDetection.bean.PsiMethodBean;
import testSmellDetection.testSmellInfo.IgnoredTest.IgnoredTestInfo;
import testSmellDetection.testSmellInfo.IgnoredTest.MethodWithIgnoredTest;
import testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;
import windowCommitConstruction.IgnoredTestCP;
import windowCommitConstruction.LackOfCohesionCP;
import windowCommitConstruction.general.RefactorWindow;
import windowCommitConstruction.general.listRenderer.CustomListRenderer2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class ITSmellPanel extends JSplitPane implements ListSelectionListener {
        private JBList smellList;
        private JBPanel refactorPreviewPanel;

        ArrayList<String> methodsNames = new ArrayList<>();

        private IgnoredTestInfo ignoredTestInfo;
        private Project project;
        private IgnoredTestCP ignoredTestCP;
        DefaultListModel model;

        Dimension minimumSize = new Dimension(150, 100);

    public ITSmellPanel(IgnoredTestInfo ignoredTestInfo, Project project, IgnoredTestCP ignoredTestCP){
            this.project = project;
            this.ignoredTestCP = ignoredTestCP;

            model = new DefaultListModel ();

            this.refactorPreviewPanel = new JBPanel();
            this.ignoredTestInfo = ignoredTestInfo;

            for(MethodWithIgnoredTest methodWithignoredTest : ignoredTestInfo.getMethodsThatIgnoredTest()){
                model.addElement(methodWithignoredTest.getMethodWithIgnoredTest().getName());
                methodsNames.add(methodWithignoredTest.getMethodWithIgnoredTest().getName());
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
            MethodWithIgnoredTest methodWithIT;
            if(index == -1 && model.getSize() == 0){
                return;
            } else if(index == -1){
                methodWithIT = ignoredTestInfo.getMethodsThatIgnoredTest().get(0);
            } else {
                methodWithIT = ignoredTestInfo.getMethodsThatIgnoredTest().get(index);
            }
            RefactorWindow refactorWindow = new RefactorWindow(methodWithIT, ignoredTestInfo, project, this);
            this.setRightComponent(refactorWindow.getRootPanel());
        }

        public void doAfterRefactor(){
            int index = smellList.getSelectedIndex();

            methodsNames.remove(index);
            ignoredTestInfo.getMethodsThatIgnoredTest().remove(index);
            model.remove(index);

            if(model.getSize() == 0){
                ignoredTestCP.doAfterRefactor();
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
