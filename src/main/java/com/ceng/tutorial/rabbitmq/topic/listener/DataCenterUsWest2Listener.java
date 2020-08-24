package com.ceng.tutorial.rabbitmq.topic.listener;

import com.ceng.tutorial.rabbitmq.topic.config.DataCenterChangeExchangeConfig;
import com.ceng.tutorial.rabbitmq.topic.model.DataCenter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DataCenterUsWest2Listener extends DataCenterListener {

    @RabbitListener(queues = DataCenterChangeExchangeConfig.DATA_CENTER_COMPLETE_US_WEST_2)
    public void consume(DataCenter dataCenter) {
        print(DataCenterChangeExchangeConfig.DATA_CENTER_COMPLETE_US_WEST_2, dataCenter);
    }

}
