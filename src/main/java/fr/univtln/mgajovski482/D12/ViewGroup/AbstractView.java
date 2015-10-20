package fr.univtln.mgajovski482.D12.ViewGroup;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Maxime on 03/10/2015.
 */
public abstract class AbstractView extends JPanel {


    private MigLayout               myLayout                = null;
    private boolean                 isInitialised           = false;
    protected static final Font     defaultFont             = ViewGroupStyle.DEFAULT_FONT;
    protected List<JComponent>      componentsToFont        = null;
    protected List<JComponent>      componentsToSetBorder   = null;

    public AbstractView(){
        myLayout  = new MigLayout();
        setLayout(myLayout);
        this.setOpaque(false);
    }

    public void initAbstractView(){
        isInitialised = true;
    }
    public boolean isInitialised() {
        return isInitialised;
    }
    protected void onExit(){}
    protected void initComponentsArrayToMod(){}

    protected void setFontOnJComponents(float fontSize){
        for(JComponent currentJComp : componentsToFont)
            currentJComp.setFont(defaultFont.deriveFont(fontSize));
    }

    protected void setBorderToJComponents(){
        for(JComponent currentJComp :componentsToSetBorder)
            currentJComp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName() + "\n");
        return stringBuilder.toString();
    }

}
