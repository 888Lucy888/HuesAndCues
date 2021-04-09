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
 * @author Carlos
 */
public class MailSender {
    public static void sendTo(String email, String text){
        
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
            
            setMessage(text, email, session);
    }
    
//    public static void sendCard(String email, ColorBlock color){
//        Properties proporties = new Properties();
//        proporties.put("mail.smtp.auth", "true");
//        proporties.put("mail.smtp.starttls.enable", "true");
//        proporties.put("mail.smtp.host", "smtp.gmail.com");
//        proporties.put("mail.smtp.port", 587);
//            
//        String myEmail = "HuesAndCuesUP@gmail.com";
//        String password = "UPOOP2021";
//            
//        Session session = Session.getInstance(proporties, new Authenticator() {
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication(){
//            return new PasswordAuthentication(myEmail, password);
//            }
//        });
//        
//        String cardContent;
//        
//        cardContent = "<html>"
//                + "<head> <style> .colored { background-color: #" + color.getColor() + ";"
//                + "width: 25px; height: 25px;} </style></head>"
//                + "<body><div><div class = 'colored'></div></div></body></html>";
//        
//        try {
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress("HuesAndCuesUP@gmail.com"));
//            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
//            msg.setSubject("Hues and Cues");
//            msg.setContent(cardContent, "text/html;charset=UTF-8");
//            msg.saveChanges();
//            Transport.send(msg);
//        } catch (AddressException ex) {
//            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MessagingException ex) {
//            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public static void sendHTML(String email, String html){
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
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("HuesAndCuesUP@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject("Hues and Cues");
            msg.setContent(html, "text/html;charset=UTF-8");
            msg.saveChanges();
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void setMessage(String text, String email, Session session){
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("HuesAndCuesUP@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject("Hues and Cues");
            msg.setText(text);
            
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
