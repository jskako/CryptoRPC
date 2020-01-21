/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

/**
 *
 * @author josips
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailRecovery {

    private String recoveryMail;
    private String recoveryPassword;
    private String recoveryUsername;

    public void MailRecovery(String RecoveryMail, String RecoveryPassword, String RecoveryUsername) {
        this.recoveryMail = RecoveryMail;
        this.recoveryPassword = RecoveryPassword;
        this.recoveryUsername = RecoveryUsername;
        final String username = "MAILADRESA@GMAIL.COM";
        final String password = "PASSWORD";

        try {
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recoveryMail));
            message.setSubject("HTR - Password Recovery");
            message.setText("Username: " + recoveryUsername
                    + "\n Password: " + recoveryPassword);

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
