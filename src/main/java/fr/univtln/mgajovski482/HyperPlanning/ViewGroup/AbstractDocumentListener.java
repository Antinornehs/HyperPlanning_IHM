package fr.univtln.mgajovski482.HyperPlanning.ViewGroup;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * <b>AbstractDocumentListener est une classe implementant DocumentListener</b>
 * Cette classe permet de simplifier l'ecriture des listeners de l'interface graphique
 *  @author Maxime
 */
public abstract class AbstractDocumentListener implements DocumentListener {

    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void changedUpdate(DocumentEvent e) {

    }
}
