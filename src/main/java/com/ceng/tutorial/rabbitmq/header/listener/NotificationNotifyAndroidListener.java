package com.ceng.tutorial.rabbitmq.header.listener;

import com.ceng.tutorial.rabbitmq.header.config.NotificationNotifyExchangeConfig;
import com.ceng.tutorial.rabbitmq.header.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationNotifyAndroidListener extends NotificationNotifyListener {

    @RabbitListener(queues = NotificationNotifyExchangeConfig.NOTIFICATION_NOTIFY_ANDROID_QUEUE)
    public void notificationNotifyAndroid(Notification notification) {
        print("Android", notification);
    }
}
