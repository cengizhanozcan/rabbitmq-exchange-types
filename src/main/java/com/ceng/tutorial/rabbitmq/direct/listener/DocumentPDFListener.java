package com.ceng.tutorial.rabbitmq.direct.listener;

import com.ceng.tutorial.rabbitmq.direct.config.DocumentCreateExchangeConfig;
import com.ceng.tutorial.rabbitmq.direct.model.Document;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DocumentPDFListener extends DocumentListener {

    @RabbitListener(queues = DocumentCreateExchangeConfig.DOCUMENT_CREATE_PDF_QUEUE)
    public void consume(Document document) {
        print(document);
    }
}
