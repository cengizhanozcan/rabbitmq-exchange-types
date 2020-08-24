package com.ceng.tutorial.rabbitmq.topic;

import com.ceng.tutorial.rabbitmq.topic.config.DataCenterChangeExchangeConfig;
import com.ceng.tutorial.rabbitmq.topic.model.DataCenter;
import com.ceng.tutorial.rabbitmq.topic.model.DataCenterRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ceng.tutorial.rabbitmq.topic.config.DataCenterChangeExchangeConfig.DATA_CENTER_COMPLETE_EXCHANGE;

@Service
public class DataCenterService {

    private final RabbitTemplate rabbitTemplate;

    public DataCenterService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public void complete(DataCenterRequest request) {
        DataCenter dataCenter = request.convert();
        rabbitTemplate.convertAndSend(DATA_CENTER_COMPLETE_EXCHANGE, dataCenter.getPath(), dataCenter);
    }
}
