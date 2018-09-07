/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.utility;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sistoandolfi
 */
public class SendMail {
    final String username = "ak12sviluppo@gmail.com";
    final String password = "ak12srl0";

    final String indirizzoMittente = "ak12sviluppo@gmail.com";
    
    final String[] indirizziDestinazione;

    Properties props = new Properties();
    
    String subject;
    String messaggio;
    
    public SendMail(String[] indirizziDestinazione) {
        this.indirizziDestinazione = indirizziDestinazione;
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public void send(){

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
                for(String indirizzoDestinazione : indirizziDestinazione){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(indirizzoMittente));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(indirizzoDestinazione));
                message.setSubject(subject);

                message.setText(messaggio);

                Transport.send(message);


            }


        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }          
    }
}
