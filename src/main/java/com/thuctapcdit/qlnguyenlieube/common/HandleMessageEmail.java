package com.thuctapcdit.qlnguyenlieube.common;

import com.thuctapcdit.qlnguyenlieube.config.RabbitMqConfig;
import com.thuctapcdit.qlnguyenlieube.dto.MessageEmail;
import com.thuctapcdit.qlnguyenlieube.dto.MessageSendPassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class HandleMessageEmail {
    private static final Logger logger = LogManager.getLogger(HandleMessageEmail.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private JavaMailSender emailSender;

    @RabbitListener(queues = RabbitMqConfig.QUEUE1)
    public void getTokenResetPassword(MessageEmail messageEmail) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(messageEmail.getEmail());
            simpleMailMessage.setSubject(messageEmail.getTitle());
            simpleMailMessage.setText(messageEmail.getContent());

            emailSender.send(simpleMailMessage);
            System.out.println("done send email");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE2)
    public void getTokenResetPassword(MessageSendPassword messageToken) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(messageToken.getAddress());
            simpleMailMessage.setSubject("TOKEN RESET PASSWORD");
            simpleMailMessage.setText("TOKEN RESET PASSWORD is : " + messageToken.getToken());

            emailSender.send(simpleMailMessage);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }


}
