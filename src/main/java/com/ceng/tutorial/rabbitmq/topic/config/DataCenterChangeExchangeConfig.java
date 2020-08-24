package com.ceng.tutorial.rabbitmq.topic.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataCenterChangeExchangeConfig {

    public static final String DATA_CENTER_COMPLETE_EXCHANGE = "data.center.complete.exchange.topic-ype";
    public static final String DATA_CENTER_COMPLETE_US_WEST_1 = "data.center.us.west.1";
    public static final String DATA_CENTER_COMPLETE_US_WEST_2 = "data.center.us.west.2";
    public static final String DATA_CENTER_COMPLETE_EU_WEST_1 = "data.center.eu.west.1";
    public static final String DATA_CENTER_COMPLETE_EU_NORTH_1 = "data.center.eu.north.1";
    public static final String DATA_CENTER_COMPLETE_EU_NORTH_2 = "data.center.eu.north.2";

    @Bean
    TopicExchange dataCenterCompleteExchange(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        return ExchangeBuilder
                .topicExchange(DATA_CENTER_COMPLETE_EXCHANGE)
                .durable(true)
                .admins(rabbitAdmin)
                .build();
    }

    @Bean
    Queue dataCenterUsWest1(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DATA_CENTER_COMPLETE_US_WEST_1)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue dataCenterUsWest2(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DATA_CENTER_COMPLETE_US_WEST_2)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue dataCenterEuWest1(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DATA_CENTER_COMPLETE_EU_WEST_1)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue dataCenterEuNorth1(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DATA_CENTER_COMPLETE_EU_NORTH_1)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }
    @Bean
    Queue dataCenterEuNorth2(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DATA_CENTER_COMPLETE_EU_NORTH_2)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Binding dataCenterUsWest1Binding(TopicExchange dataCenterCompleteExchange,
                                     Queue dataCenterUsWest1){
        return BindingBuilder
                .bind(dataCenterUsWest1)
                .to(dataCenterCompleteExchange)
                .with("data.center.*.west.*");
    }

    @Bean
    Binding dataCenterUsWest2Binding(TopicExchange dataCenterCompleteExchange,
                                     Queue dataCenterUsWest2){
        return BindingBuilder
                .bind(dataCenterUsWest2)
                .to(dataCenterCompleteExchange)
                .with("data.center.*.west.*");
    }

    @Bean
    Binding dataCenterEuWest1Binding(TopicExchange dataCenterCompleteExchange,
                                     Queue dataCenterEuWest1){
        return BindingBuilder
                .bind(dataCenterEuWest1)
                .to(dataCenterCompleteExchange)
                .with("data.center.*.west.*");
    }

    @Bean
    Binding dataCenterEuNorth1Binding(TopicExchange dataCenterCompleteExchange,
                                     Queue dataCenterEuNorth1){
        return BindingBuilder
                .bind(dataCenterEuNorth1)
                .to(dataCenterCompleteExchange)
                .with("data.center.eu.north.*");
    }

    @Bean
    Binding dataCenterEuNorth2Binding(TopicExchange dataCenterCompleteExchange,
                                     Queue dataCenterEuNorth2){
        return BindingBuilder
                .bind(dataCenterEuNorth2)
                .to(dataCenterCompleteExchange)
                .with("data.center.eu.north.*");
    }

}
