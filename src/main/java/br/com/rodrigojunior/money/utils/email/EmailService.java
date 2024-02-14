package br.com.rodrigojunior.money.utils.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String recipient, String subject, String htmlBody) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipient);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // O segundo parâmetro indica que o conteúdo é HTML

            javaMailSender.send(message);
            System.out.println("E-mail HTML enviado com sucesso para: " + recipient);
        } catch (MessagingException e) {
            System.out.println("Falha ao enviar o e-mail HTML para: " + recipient);
            e.printStackTrace();
        }
    }
}
