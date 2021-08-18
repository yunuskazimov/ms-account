package az.bank.account.msaccount.queue;

import az.bank.account.msaccount.model.MailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountMailSender {
    private final RabbitTemplate rabbitTemplate;

    public AccountMailSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMail(MailDto dto) {
        rabbitTemplate.convertAndSend("MAIL_SENDER_Q", dto);
    }
}
