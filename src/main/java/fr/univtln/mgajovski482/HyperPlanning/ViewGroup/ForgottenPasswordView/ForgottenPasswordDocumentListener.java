package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ForgottenPasswordView;

import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractDocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;

/**
 * Created by Maxime on 16/10/2015.
 */
public class ForgottenPasswordDocumentListener  extends AbstractDocumentListener {

    public static final ForgottenPasswordView view = ForgottenPasswordView.getInstance();
    public static final JButton confirmButton = view.getValidateJButton();

    private static String email, confirmEmail;

    public ForgottenPasswordDocumentListener(){
    }

    public void changedUpdate(DocumentEvent e) {

        email            = view.getEmailJTextField()        .getText();
        confirmEmail     = view.getConfirmEmailJTextField() .getText();

        confirmButton.setEnabled(false);
        if(email.equals(confirmEmail))
            confirmButton.setEnabled(true);
    }
}
