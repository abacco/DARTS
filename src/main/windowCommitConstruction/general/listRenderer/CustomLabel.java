package main.windowCommitConstruction.general.listRenderer;


import main.testSmellDetection.testSmellInfo.TestSmellInfo;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel{

    private static final Color selectionColor = new Color ( 82, 158, 202 );

    private boolean selected = false;
    private TestSmellInfo testSmellData;

    public CustomLabel ()
    {
        super ();
        setOpaque ( true );
        setBorder ( BorderFactory.createEmptyBorder ( 20, 20, 20, 20 ) );
    }

    public void setSelected ( boolean selected )
    {
        this.selected = selected;
        setForeground ( selected ? Color.WHITE : Color.BLACK);
        if(selected){
            this.setBackground(Color.darkGray);
        } else {
            this.setBackground(Color.pink);
        }
    }

    public void setData ( TestSmellInfo smellInfo )
    {
        this.testSmellData = smellInfo;
        setText(testSmellData.getClassWithSmell().getName());
    }

    @Override
    public Dimension getPreferredSize ()
    {
        final Dimension ps = super.getPreferredSize ();
        ps.height = 36;
        return ps;
    }

    /* Getters & Setters */

    public TestSmellInfo getTestSmellData() {
        return testSmellData;
    }

    public void setTestSmellData(TestSmellInfo testSmellData) {
        this.testSmellData = testSmellData;
    }
}
