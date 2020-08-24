package com.ceng.tutorial.rabbitmq.header.config;

import com.ceng.tutorial.rabbitmq.header.model.Device;
import com.ceng.tutorial.rabbitmq.header.model.Platform;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class NotificationNotifyExchangeConfig {

    public static final String NOTIFICATION_NOTIFY_EXCHANGE = "notification.notify.exchange.header-type";
    public static final String NOTIFICATION_NOTIFY_ANDROID_QUEUE = "notification.notify.android.queue";
    public static final String NOTIFICATION_NOTIFY_IOS_QUEUE = "notification.notify.ios.queue";
    public static final String NOTIFICATION_NOTIFY_WEB_QUEUE = "notification.notify.web.queue";

    @Bean
    HeadersExchange notificationNotifyExchange(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        return ExchangeBuilder
                .headersExchange(NOTIFICATION_NOTIFY_EXCHANGE)
                .durable(true)
                .admins(rabbitAdmin)
                .build();
    }

    @Bean
    Queue notificationNotifyAndroidQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(NOTIFICATION_NOTIFY_ANDROID_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue notificationNotifyIosQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(NOTIFICATION_NOTIFY_IOS_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue notificationNotifyWebQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(NOTIFICATION_NOTIFY_WEB_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Binding notificationNotifyAndroidBinding(HeadersExchange notificationNotifyExchange,
                                             Queue notificationNotifyAndroidQueue) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("platform", Platform.MOBILE.toString());
        maps.put("device", Device.ANDROID.toString());

        return BindingBuilder
                .bind(notificationNotifyAndroidQueue)
                .to(notificationNotifyExchange)
                .whereAny(maps)
                .match();
    }

    @Bean
    Binding notificationNotifyIosBinding(HeadersExchange notificationNotifyExchange,
                                         Queue notificationNotifyIosQueue) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("platform", Platform.MOBILE.toString());
        maps.put("device", Device.IOS.toString());

        return BindingBuilder
                .bind(notificationNotifyIosQueue)
                .to(notificationNotifyExchange)
                .whereAny(maps)
                .match();
    }

    @Bean
    Binding notificationNotifyWEBBinding(HeadersExchange notificationNotifyExchange,
                                         Queue notificationNotifyWebQueue) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("platform", Platform.WEB.toString());

        return BindingBuilder
                .bind(notificationNotifyWebQueue)
                .to(notificationNotifyExchange)
                .whereAny(maps)
                .match();
    }

}
