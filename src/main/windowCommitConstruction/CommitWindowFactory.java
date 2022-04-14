package main.windowCommitConstruction;

import com.intellij.openapi.project.Project;
import main.testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import main.testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import main.testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CommitWindowFactory {
    private static JPanel generalFixturePanel;
    private static JPanel eagerTestPanel;
    private static JPanel lackOfCohesionPanel;

    public static void createWindow(Boolean textual, Boolean structural,
                                    String project,
                                    ArrayList<GeneralFixtureInfo> listGFI,
                                    ArrayList<EagerTestInfo> listETI,
                                    ArrayList<LackOfCohesionInfo> listLOCI) {
        CommitPrincipalFrame principalFrame = null;
        //Controllo per vedere se la window esiste già.
        boolean frameExist = false;
        Frame[] frames = JFrame.getFrames();
        for(Frame frame : frames){
            if(frame.getName().equals("DARTSCommitWindow")){
                principalFrame = (CommitPrincipalFrame) frame;
                frameExist = true;
            }
        }
        if(!frameExist){
            principalFrame = new CommitPrincipalFrame();
            principalFrame.setName("DARTSCommitWindow");
            principalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        JTabbedPane detectionTp =  principalFrame.getDetectionTp();
        if(textual){
            principalFrame.removeTextualPanel();
            principalFrame.addTextualPanel(createPanel(project, listGFI, listETI, listLOCI));
        }
        if(structural){
            principalFrame.removeStructuralPanel();
            principalFrame.addStructuralPanel(createPanel(project, listGFI, listETI, listLOCI));
        }
        principalFrame.add(detectionTp);
        // Mostra la schermata al centro dello schermo
        principalFrame.setLocationRelativeTo(null);

        //Imposta la dimensione della finestra in modo che si adatti al suo contenuto
        principalFrame.pack();

        principalFrame.setVisible(true);
    }

    public static void createWindow(Boolean textual, Boolean structural,
                                    Project project,
                                    ArrayList<GeneralFixtureInfo> listGFI,
                                    ArrayList<EagerTestInfo> listETI,
                                    ArrayList<LackOfCohesionInfo> listLOCI) {
        CommitPrincipalFrame principalFrame = null;
        //Controllo per vedere se la window esiste già.
        boolean frameExist = false;
        Frame[] frames = JFrame.getFrames();
        for(Frame frame : frames){
            if(frame.getName().equals("DARTSCommitWindow")){
                principalFrame = (CommitPrincipalFrame) frame;
                frameExist = true;
            }
        }
        if(!frameExist){
            principalFrame = new CommitPrincipalFrame();
            principalFrame.setName("DARTSCommitWindow");
            principalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        JTabbedPane detectionTp =  principalFrame.getDetectionTp();
        if(textual){
            principalFrame.removeTextualPanel();
            principalFrame.addTextualPanel(createPanel(project, listGFI, listETI, listLOCI));
        }
        if(structural){
            principalFrame.removeStructuralPanel();
            principalFrame.addStructuralPanel(createPanel(project, listGFI, listETI, listLOCI));
        }
        principalFrame.add(detectionTp);
        // Mostra la schermata al centro dello schermo
        principalFrame.setLocationRelativeTo(null);

        //Imposta la dimensione della finestra in modo che si adatti al suo contenuto
        principalFrame.pack();

        principalFrame.setVisible(true);
    }

    private static JTabbedPane createPanel(Project project,
                                            ArrayList<GeneralFixtureInfo> listGFI,
                                            ArrayList<EagerTestInfo> listETI,
                                            ArrayList<LackOfCohesionInfo> listLOCI){
        // Controllo se ho trovato degli smells.
        if (listGFI != null) {
            generalFixturePanel = new GeneralFixtureCP(listGFI, project);
        }
        if (listETI != null) {
            eagerTestPanel = new EagerTestCP(listETI, project);
        }
        if (listLOCI != null){
            lackOfCohesionPanel = new LackOfCohesionCP(listLOCI, project);
        }

        //In questa parte costruisco le tab della window.
        JTabbedPane tp = new JTabbedPane();
        tp.setPreferredSize(new Dimension(1000, 500));
        if(listGFI != null){
            JScrollPane scroll = new JScrollPane(generalFixturePanel);
            tp.add("GeneralFixture", scroll);
        }
        if (listETI != null){
            JScrollPane scroll = new JScrollPane(eagerTestPanel);
            tp.add("EagerTest", scroll);
        }
        if (listLOCI != null) {
            JScrollPane scroll = new JScrollPane(lackOfCohesionPanel);
            tp.add("LackOfCohesion", scroll);
        }
        return tp;
    }

    private static JTabbedPane createPanel(String project,
                                           ArrayList<GeneralFixtureInfo> listGFI,
                                           ArrayList<EagerTestInfo> listETI,
                                           ArrayList<LackOfCohesionInfo> listLOCI){
        // Controllo se ho trovato degli smells.
/*        if (listGFI != null) {
            generalFixturePanel = new GeneralFixtureCP(listGFI, project);
        }
        if (listETI != null) {
            eagerTestPanel = new EagerTestCP(listETI, project);
        }
        if (listLOCI != null){
            lackOfCohesionPanel = new LackOfCohesionCP(listLOCI, project);
        }*/

        //In questa parte costruisco le tab della window.
        JTabbedPane tp = new JTabbedPane();
        tp.setPreferredSize(new Dimension(1000, 500));
        if(listGFI != null){
            JScrollPane scroll = new JScrollPane(generalFixturePanel);
            tp.add("GeneralFixture", scroll);
        }
        if (listETI != null){
            JScrollPane scroll = new JScrollPane(eagerTestPanel);
            tp.add("EagerTest", scroll);
        }
        if (listLOCI != null) {
            JScrollPane scroll = new JScrollPane(lackOfCohesionPanel);
            tp.add("LackOfCohesion", scroll);
        }
        return tp;
    }
}
