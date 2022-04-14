package main.windowCommitConstruction.general.listRenderer;


import javax.swing.*;
import java.awt.*;

public class CustomLabel2 extends JLabel {
    private boolean selected = false;
    private String data;

    public CustomLabel2 ()
    {
        super ();
        setOpaque ( true );
        setBorder ( BorderFactory.createEmptyBorder ( 5, 5, 5, 5 ) );
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

    public void setData ( String data )
    {
        this.data = data;
        setText(data);
    }

    @Override
    public Dimension getPreferredSize ()
    {
        final Dimension ps = super.getPreferredSize ();
        ps.height = 36;
        return ps;
    }

    /* Getters & Setters */

    public String getData() {
        return data;
    }


}
