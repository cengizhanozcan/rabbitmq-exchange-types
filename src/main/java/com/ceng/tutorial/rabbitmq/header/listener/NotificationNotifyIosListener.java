package com.ceng.tutorial.rabbitmq.header.listener;

import com.ceng.tutorial.rabbitmq.header.config.NotificationNotifyExchangeConfig;
import com.ceng.tutorial.rabbitmq.header.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationNotifyIosListener extends NotificationNotifyListener {

    @RabbitListener(queues = NotificationNotifyExchangeConfig.NOTIFICATION_NOTIFY_IOS_QUEUE)
    public void notificationNotifyIos(Notification notification) {
        print("IOS", notification);
    }
}
