package fr.univtln.mgajovski482.HyperPlanning.ViewGroup;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created by Maxime on 16/10/2015.
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
