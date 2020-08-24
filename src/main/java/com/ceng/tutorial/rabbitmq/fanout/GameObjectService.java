package com.ceng.tutorial.rabbitmq.fanout;

import com.ceng.tutorial.rabbitmq.fanout.model.GameObject;
import com.ceng.tutorial.rabbitmq.fanout.model.GameObjectCreateRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ceng.tutorial.rabbitmq.fanout.config.GameObjectCreatedExchangeConfig.GAME_OBJECT_CREATE_CLIENT_EXCHANGE;

@Service
public class GameObjectService {

    private final RabbitTemplate rabbitTemplate;

    public GameObjectService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public void create(GameObjectCreateRequest request) {
        GameObject gameObject = request.convert();
        rabbitTemplate.convertAndSend(GAME_OBJECT_CREATE_CLIENT_EXCHANGE, "", gameObject);
    }
}
