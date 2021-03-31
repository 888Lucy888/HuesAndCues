/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Guest
 */
public class MailSender {
    public static void sendTo(String email){
        
        try {
            Properties proporties = new Properties();
            proporties.put("mail.smtp.auth", "true");
            proporties.put("mail.smtp.starttls.enable", "true");
            proporties.put("mail.smtp.host", "smtp.gmail.com");
            proporties.put("mail.smtp.port", 587);
            
            String myEmail = "HuesAndCuesUP@gmail.com";
            String password = "UPOOP2021";
            
            Session session = Session.getInstance(proporties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myEmail, password);
                }
            });
            
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject("Hues and Cues");
            msg.setText("Test Email by Carlos");
            
            Transport.send(msg);
            
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
