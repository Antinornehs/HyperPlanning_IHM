package fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.DocumentListener;

import fr.univtln.mgajovski482.D12.ViewGroup.AbstractDocumentListener;
import fr.univtln.mgajovski482.D12.ViewGroup.SignUpView.SignUpConnectionLogsView;
import fr.univtln.mgajovski482.D12.ViewGroup.ViewGroupRegex;
import fr.univtln.mgajovski482.d12.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.util.logging.Logger;

/**
 * Created by Maxime on 17/10/2015.
 */
public class SignUpConnectionLogsDocumentListener extends AbstractDocumentListener {

    private static Logger logger = Logger.getLogger("SignUpConnectionLogsDocumentListener.class");

    private static final SignUpConnectionLogsView view   = SignUpConnectionLogsView.getInstance();
    private static final  JButton validJButton           = view.getConfirmJButton();

    private static RUConnectionLogs ruConnectionLogs;
    private static String   emailToTest, confirmEmailToTest,
                            passwordToTest, passwordConfirmToTest;

    private static boolean  emailIsCorrect, passwordIsCorrect;

    public SignUpConnectionLogsDocumentListener(){
    }

    public void changedUpdate(DocumentEvent e) {
        passwordConfirmToTest   = String.copyValueOf(view.getConfirmPasswordJPasswordField().getPassword());
        passwordToTest          = String.copyValueOf(view.getPasswordJPasswordField().getPassword());
        emailToTest             = view.getEmailJTextField().getText();
        confirmEmailToTest      = view.getConfirmEmailJTextField().getText();
        emailIsCorrect          = emailToTest.matches      (ViewGroupRegex.EMAIL_REGEX);
        passwordIsCorrect       = passwordToTest.matches   (ViewGroupRegex.USER_PASSWORD_REGEX);

        validJButton.setEnabled(false);
        if(conditionsAreOkay()) validJButton.setEnabled(true);
    }

    public static RUConnectionLogs getRuConnectionLogs() {
        return ruConnectionLogs;
    }

    public static void createConnectionLogs(){
        logger.info("ConnectionLogs Created Correctly !");
        ruConnectionLogs = new RUConnectionLogs(emailToTest, passwordToTest);

    }

    private boolean conditionsAreOkay(){
        return (passwordToTest.equals(passwordConfirmToTest) &&
                emailToTest.equals(confirmEmailToTest) &&
                passwordIsCorrect && emailIsCorrect) ? true : false;
    }

}
