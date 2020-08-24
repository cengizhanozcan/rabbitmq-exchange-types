package com.ceng.tutorial.rabbitmq.fanout.listener;

import com.ceng.tutorial.rabbitmq.fanout.config.GameObjectCreatedExchangeConfig;
import com.ceng.tutorial.rabbitmq.fanout.model.GameObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GameObjectCreateMobileClientListener extends GameObjectCreateClientListener {

    @RabbitListener(queues = GameObjectCreatedExchangeConfig.GAME_OBJECT_CREATE_MOBILE_CLIENT_QUEUE)
    public void consume(GameObject gameObject) {
        print("Mobile", gameObject);
    }

}
