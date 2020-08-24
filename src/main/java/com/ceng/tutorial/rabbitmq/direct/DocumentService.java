package com.ceng.tutorial.rabbitmq.direct;

import com.ceng.tutorial.rabbitmq.direct.model.Document;
import com.ceng.tutorial.rabbitmq.direct.model.DocumentCreateRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ceng.tutorial.rabbitmq.direct.config.DocumentCreateExchangeConfig.DOCUMENT_CREATE_EXCHANGE_NAME;

@Service
public class DocumentService {

    private final RabbitTemplate rabbitTemplate;

    public DocumentService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public void create(DocumentCreateRequest request) {
        Document document = request.convert();
        rabbitTemplate.convertAndSend(DOCUMENT_CREATE_EXCHANGE_NAME, document.getDocumentType().toString(), document);
    }
}
