package fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ScreenTitleView;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.AbstractDocumentListener;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ViewGroupRegex;
import fr.univtln.mgajovski482.HyperPlanning.Dao.entityManagers.RegisteredUserManager;

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

    public boolean logInButtonController(){ //Je ne sais pas comment appeler cette méthode l186 de ScreenTitleView
        userName    = view.getLoginJTextField().getText();
        password    = String.copyValueOf(view.getPasswordJPasswordField().getPassword());

        RegisteredUserManager rum = new RegisteredUserManager();
        AbstractRegUser r = rum.get("mail");
        if(userName.equals(r.getRuConnectionLogs().getEmail()) && password.equals(r.getRuConnectionLogs().getPassword())){
            return true; // là il faudrait ouvrir la suite de l'application
        }else {
            return false; // là les logs ne sont pas bons
        }
    }
}
