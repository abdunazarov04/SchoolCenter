package uz.isystem.s.students.util;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private MailSender mailSender;
    public void send(String to, String title, String concat){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(concat);
        mailSender.send(mailMessage);
    }
}
