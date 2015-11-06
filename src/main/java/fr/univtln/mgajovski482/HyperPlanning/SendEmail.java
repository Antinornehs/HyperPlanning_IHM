package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.Other.Default_Consts;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.AbstractRegUser;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUConnectionLogs;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.RegisteredUserLogs.RUPersonalLogs;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ContactWebmaster.ContactWebmasterView;
import fr.univtln.mgajovski482.HyperPlanning.ViewGroup.ForgottenPasswordView.ForgottenPasswordView;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * <b>SendMail est la classe permettant la reception et l'envoi de mail
 * à travers les vues :</b>
 *
 * <p>
 * <ul>
 *     <li>ContactWebMaster (Envoi de mail a l'adresse mail WebMaster)</li>
 *     <li>ForgottenPassWord(Envoi de passwords perdus aux utilisateurs)</li>
 * </ul>
 *
 * <p>
 * Un logger nous permet de nous assurer que tout s'est bien deroule.
 *
 *  @author Maxime
 */

public class SendEmail {


    private static Logger logger                    = Logger.getLogger("SendEmail.class");
    
    public static final ForgottenPasswordView forgottenPasswordview = ForgottenPasswordView.getInstance();
    public static final ContactWebmasterView contactWebmasterView   = ContactWebmasterView.getInstance();

    private static final String FORGOTTEN_PASSWORD_MESSAGE_SUBJECT = "Mot de passe HyperPlanning";
    
    private static final String ADMIN_EMAIL     = Default_Consts.ADMIN_EMAIL;
    private static final String ADMIN_PASSWORD  = Default_Consts.ADMIN_PASSWORD;
    
    private static String               userMail;
    private static String               contactWebmasterMessageSubject;
    private static String               contactWebmasterMessageBody;
    private static AbstractRegUser      currentUser;

    private static Properties props;
    private static Session session;
    private static Message message;
    
    public static void forgottenPasswordMessage() {

        userMail = forgottenPasswordview.getEmailJTextField().getText();
        currentUser = AbstractRegUser.staticRegUsersMap.get(userMail);

        initProperties();
        initSession();
        initMessage(
                ADMIN_EMAIL, userMail,
                FORGOTTEN_PASSWORD_MESSAGE_SUBJECT,
                forgottenPasswordBodyMessage());

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        logger.info("An Email was send to the user Mail !");
    }

    public static void sendContactWebmasterMessage() {

        userMail                        = contactWebmasterView.getAuthorJTextField().getText();
        contactWebmasterMessageSubject  = contactWebmasterView.getTopicJTextField().getText();
        contactWebmasterMessageBody     = contactWebmasterView.getMessageJTextArea().getText();

        currentUser = AbstractRegUser.staticRegUsersMap.get(userMail);

        initProperties();
        initSession();
        initMessage(
                userMail, ADMIN_EMAIL,
                contactWebmasterMessageSubject,
                contactWebmasterBodyMessage(contactWebmasterMessageBody));

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.info("Message send to Webmaster !");
    }

    public static void initMessage(String fromMail, String toMail,
                                   String subject, String body){

        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
            message.setSubject(subject);
            message.setText(body);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    
    public static String forgottenPasswordBodyMessage(){

        RUPersonalLogs      personalLogs    = currentUser.getRuPersonalLogs();
        RUConnectionLogs    connectionLogs  = currentUser.getRuConnectionLogs();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append((personalLogs.isMale() ? "Cher M. " : "Chère Mme "));
        stringBuilder.append(personalLogs.getLastName() + " " + personalLogs.getFirstName() + ",\n");
        stringBuilder.append("Le mot de passe associé à l'adresse : " + userMail);
        stringBuilder.append(" est : " + connectionLogs.getPassword());
        return stringBuilder.toString();
    }



    public static String contactWebmasterBodyMessage(String bodyMessage){

        RUPersonalLogs      personalLogs    = currentUser.getRuPersonalLogs();
        RUConnectionLogs    connectionLogs  = currentUser.getRuConnectionLogs();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((personalLogs.isMale() ? "M. " : "Mme "));
        stringBuilder.append(personalLogs.getLastName() + " " + personalLogs.getFirstName() + " ");
        stringBuilder.append("[ " + personalLogs.getStatus() + " ] ");
        stringBuilder.append("vous a envoyé un message : \n\n");
        stringBuilder.append(bodyMessage);
        return stringBuilder.toString();
    }

    public static void initProperties() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    public static void initSession(){
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_PASSWORD);
                    }
                });

    }
}
