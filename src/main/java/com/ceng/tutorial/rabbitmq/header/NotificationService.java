package com.ceng.tutorial.rabbitmq.header;

import com.ceng.tutorial.rabbitmq.header.model.Notification;
import com.ceng.tutorial.rabbitmq.header.model.NotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ceng.tutorial.rabbitmq.header.config.NotificationNotifyExchangeConfig.NOTIFICATION_NOTIFY_EXCHANGE;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public void notify(NotificationRequest request) throws JsonProcessingException {
        Notification notification = request.convert();

        rabbitTemplate.convertAndSend(NOTIFICATION_NOTIFY_EXCHANGE, "", notification, message -> {
            message.getMessageProperties().getHeaders().put("platform", notification.getPlatform());
            message.getMessageProperties().getHeaders().put("device", notification.getDevice());
            return message;
        });
    }

}
