package main.oldWindowConstruction;

import com.intellij.openapi.project.Project;
import main.testSmellDetection.testSmellInfo.eagerTest.EagerTestInfo;
import main.testSmellDetection.testSmellInfo.generalFixture.GeneralFixtureInfo;
import main.testSmellDetection.testSmellInfo.lackOfCohesion.LackOfCohesionInfo;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TestSmellWindowFactory {
    private static JPanel generalFixturePanel;
    private static JPanel eagerTestPanel;
    private static JPanel lackOfCohesionPanel;

    public static void createWindow(Boolean textual, Boolean structural,
                                    Project project,
                                    ArrayList<GeneralFixtureInfo> listGFI,
                                    ArrayList<EagerTestInfo> listETI,
                                    ArrayList<LackOfCohesionInfo> listLOCI) {
        PrincipalFrame principalFrame = null;
        //Controllo per vedere se la window esiste già.
        boolean frameExist = false;
        Frame[] frames = JFrame.getFrames();
        for(Frame frame : frames){
            if(frame.getName().equals("DARTSWindow")){
                principalFrame = (PrincipalFrame) frame;
                frameExist = true;
            }
        }
        if(!frameExist){
            principalFrame = new PrincipalFrame();
            principalFrame.setName("DARTSWindow");
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
            generalFixturePanel = new GeneralFixturePanel(listGFI, project);
        }
        if (listETI != null) {
            eagerTestPanel = new EagerTestPanel(listETI, project);
        }
        if (listLOCI != null){
            lackOfCohesionPanel = new LackOfCohesionPanel(listLOCI, project);
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

}
