package com.ceng.tutorial.rabbitmq.fanout.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameObjectCreatedExchangeConfig {

    public static final String GAME_OBJECT_CREATE_CLIENT_EXCHANGE = "game.object.create.client.exchange.fanout-type";
    public static final String GAME_OBJECT_CREATE_MOBILE_CLIENT_QUEUE = "game.object.create.mobile.client.queue";
    public static final String GAME_OBJECT_CREATE_PC_CLIENT_QUEUE = "game.object.create.pc.client.queue";
    public static final String GAME_OBJECT_CREATE_PS_CLIENT_QUEUE = "game.object.create.ps.client.queue";

    @Bean
    FanoutExchange gameObjectCreateClientExchange(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        return ExchangeBuilder
                .fanoutExchange(GAME_OBJECT_CREATE_CLIENT_EXCHANGE)
                .admins(rabbitAdmin)
                .durable(true)
                .build();
    }

    @Bean
    Queue gameObjectCreateMobileClientQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(GAME_OBJECT_CREATE_MOBILE_CLIENT_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue gameObjectCreatePCClientQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(GAME_OBJECT_CREATE_PC_CLIENT_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue gameObjectCreatePSClientQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(GAME_OBJECT_CREATE_PS_CLIENT_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Binding gameObjectMobileBinding(Queue gameObjectCreateMobileClientQueue,
                                    FanoutExchange gameObjectCreateClientExchange) {
        return BindingBuilder
                .bind(gameObjectCreateMobileClientQueue)
                .to(gameObjectCreateClientExchange);
    }

    @Bean
    Binding gameObjectPCBinding(Queue gameObjectCreatePCClientQueue,
                                FanoutExchange gameObjectCreateClientExchange) {
        return BindingBuilder
                .bind(gameObjectCreatePCClientQueue)
                .to(gameObjectCreateClientExchange);
    }

    @Bean
    Binding gameObjectPSBinding(Queue gameObjectCreatePSClientQueue,
                                FanoutExchange gameObjectCreateClientExchange) {
        return BindingBuilder
                .bind(gameObjectCreatePSClientQueue)
                .to(gameObjectCreateClientExchange);
    }

}
