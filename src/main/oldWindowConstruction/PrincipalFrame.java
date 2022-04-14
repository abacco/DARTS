package main.oldWindowConstruction;



import javax.swing.*;

public class PrincipalFrame extends JFrame {
    private JTabbedPane detectionTp;
    private JTabbedPane textualTp;
    private JTabbedPane structuralTp;

    public PrincipalFrame(){
        super("DARTS");
        detectionTp = new JTabbedPane();
        textualTp = null;
        structuralTp = null;
    }

    public void addTextualPanel(JTabbedPane textualTp){
        this.setTextualTp(textualTp);
        detectionTp.add("Textual Detection", textualTp);
    }

    public void addStructuralPanel(JTabbedPane structuralTp){
        this.setStructuralTp(structuralTp);
        detectionTp.add("Structural Detection", structuralTp);
    }

    public void removeTextualPanel(){
        detectionTp.remove(textualTp);
        textualTp = null;
    }

    public void removeStructuralPanel(){
        detectionTp.remove(structuralTp);
        structuralTp = null;
    }

    /* GETTERS & SETTERS */
    public JTabbedPane getDetectionTp(){
        return detectionTp;
    }

    public void setDetectionTp(JTabbedPane detectionTp) {
        this.detectionTp = detectionTp;
    }

    public JTabbedPane getTextualTp() {
        return textualTp;
    }

    public void setTextualTp(JTabbedPane textualTp) {
        this.textualTp = textualTp;
    }

    public JTabbedPane getStructuralTp() {
        return structuralTp;
    }

    public void setStructuralTp(JTabbedPane structuralTp) {
        this.structuralTp = structuralTp;
    }
}
