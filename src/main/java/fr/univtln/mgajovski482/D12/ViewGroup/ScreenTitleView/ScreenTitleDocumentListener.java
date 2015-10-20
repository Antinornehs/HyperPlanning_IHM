package fr.univtln.mgajovski482.D12.ViewGroup.ScreenTitleView;

import fr.univtln.mgajovski482.D12.ViewGroup.AbstractDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupRegex;

import javax.swing.*;
import javax.swing.event.DocumentEvent;

/**
 * Created by Maxime on 16/10/2015.
 */
public class ScreenTitleDocumentListener extends AbstractDocumentListener {

    public static final     ScreenTitleView view   = ScreenTitleView.getInstance();
    public static final     JButton logInButton     = view.getLogInJButton();

    private static String  userName, password;
    private static boolean userNameIsCorrect, passwordIsCorrect;


    public ScreenTitleDocumentListener(){
    }

    public void changedUpdate(DocumentEvent e) {

        userName    = view.getLoginJTextField().getText();
        password    = String.copyValueOf(view.getPasswordJPasswordField().getPassword());

        userNameIsCorrect   =   userName.matches(ViewGroupRegex.EMAIL_REGEX);
        passwordIsCorrect   =   password.matches(ViewGroupRegex.USER_PASSWORD_REGEX);

        logInButton.setEnabled(false);
        if(passwordIsCorrect && userNameIsCorrect)
            logInButton.setEnabled(true);



    }
}
