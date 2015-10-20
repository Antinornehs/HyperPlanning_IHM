package fr.univtln.mgajovski482.D12.ViewGroup;

import fr.univtln.mgajovski482.D12.ViewGroup.ForgottenPasswordView.ForgottenPasswordView;

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
