package eapli.base.APIs.email;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailAPI {
    public EmailAPI() {
        throw new IllegalArgumentException("Utility Only class");
    }


    private static final String USERNAME = "lapr4G1DD@gmail.com";
    private static final String ACCESS = "lapr4Grupo1DD";
    private static final String EMAIL_FROM = "lapr4G1DD@gmail.com";
    private static final Logger DEFAULT_EMAIL = Logger.getLogger(EmailAPI.class.getName());
    private static final String SMTP_SERVER = "smtp.gmail.com";

    public static void sendMail(String email, String subject, String text) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", SMTP_SERVER);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            msg.setFrom(new InternetAddress(EMAIL_FROM));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
            msg.setSubject(subject);
            msg.setText(text);
            msg.setSentDate(new Date());
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect(SMTP_SERVER, USERNAME, ACCESS);
            t.sendMessage(msg, msg.getAllRecipients());
            DEFAULT_EMAIL.log(Level.INFO, t.getLastServerResponse());
            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static boolean sendEmailToClient(String userEmail,String subject, String text) {
        if (userEmail.isEmpty()) {
            return false;
        }
        try {
            sendMail(userEmail, subject, text);
        } catch (Exception e) {
            DEFAULT_EMAIL.log(Level.WARNING, e.getMessage());
            return false;
        }
        return true;
    }



}

