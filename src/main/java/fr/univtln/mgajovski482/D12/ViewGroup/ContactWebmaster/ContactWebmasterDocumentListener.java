package fr.univtln.mgajovski482.D12.ViewGroup.ContactWebmaster;

import fr.univtln.mgajovski482.D12.ViewGroup.AbstractDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupRegex;

import javax.swing.*;
import javax.swing.event.DocumentEvent;

/**
 * Created by Maxime on 16/10/2015.
 */
public class ContactWebmasterDocumentListener extends AbstractDocumentListener {

    public static final ContactWebmasterView view = ContactWebmasterView.getInstance();
    public static final JButton confirmButton = view.getValidateJButton();

    private static String author,topic, message;

    private static boolean authorIsCorrect;

    public ContactWebmasterDocumentListener(){
    }

    public void changedUpdate(DocumentEvent e) {
        author              = view.getAuthorJTextField().getText();
        topic               = view.getTopicJTextField() .getText();
        message             = view.getMessageJTextArea().getText();

        authorIsCorrect = author.matches(ViewGroupRegex.EMAIL_REGEX);

        confirmButton.setEnabled(false);
        if(authorIsCorrect && topic.length() != 0 && message.length() != 0)
            confirmButton.setEnabled(true);
    }
}

