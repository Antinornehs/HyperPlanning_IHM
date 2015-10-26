/*package fr.univtln.mgajovski482.D12.ViewGroup.ForgottenPasswordView;
package com.javapapers.java;

        import java.util.Properties;

        import javax.mail.Message;
        import javax.mail.MessagingException;
        import javax.mail.Session;
        import javax.mail.Transport;
        import javax.mail.internet.AddressException;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;

public class SendEmail {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public static void sendMessage(){

        JavaEmail javaEmail = new JavaEmail();

        javaEmail.setMailServerProperties();
        javaEmail.createEmailMessage();
        javaEmail.sendEmail();

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

        String[] toEmails = { "joe@javapapers.com" };
        String emailSubject = "Java Email";
        String emailBody = "This is an email sent by JavaMail api.";

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (int i = 0; i < toEmails.length; i++) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");//for a html email
        //emailMessage.setText(emailBody);// for a text email

        String emailHost = "smtp.gmail.com";
        String fromUser = "your emailid here";//just the id alone without @gmail.com
        String fromUserEmailPassword = "your email password here";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
    }
}
*/