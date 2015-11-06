package fr.univtln.mgajovski482.HyperPlanning.ViewGroup;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * <b>AbstractView est une classe mere abstraite qui va etre heritee par toutes les vues
 * de l'interface graphique</b>
 *
 * <p>
 * La classe AbstractView est caracterisee par :
 * <ul>
 *     <li>Un Layout (migLayout) qui est de meme type pour chaque classe fille.</li>
 *     <li>Un boolean d'initialisation qui passe a true quand une classe fille a ete
 *     initialisee</li>
 *     <li>Une police d'ecriture par defaut</li>
 *     <li>Une liste des JComponents qui doivent emprunter la police par defaut</li>
 *     <li>Une liste des JComponents auxquels on ajoute des bordures de couleur noire</li>
 * </ul>
 *
 *  @author Maxime
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
