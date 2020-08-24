package com.ceng.tutorial.rabbitmq.direct.config;

import com.ceng.tutorial.rabbitmq.direct.model.DocumentType;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentCreateExchangeConfig {

    public static final String DOCUMENT_CREATE_EXCHANGE_NAME = "document.create.exchange.direct-type";
    public static final String DOCUMENT_CREATE_PDF_QUEUE = "document.create.pdf.queue";
    public static final String DOCUMENT_CREATE_WORD_QUEUE = "document.create.word.queue";
    public static final String DOCUMENT_CREATE_EXCEL_QUEUE = "document.create.excel.queue";

    @Bean
    DirectExchange documentCreateDirectExchange(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        return ExchangeBuilder
                .directExchange(DOCUMENT_CREATE_EXCHANGE_NAME)
                .admins(rabbitAdmin)
                .durable(true)
                .build();
    }

    @Bean
    Queue documentCreatePdfQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DOCUMENT_CREATE_PDF_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue documentCreateWordQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DOCUMENT_CREATE_WORD_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Queue documentCreateExcelQueue(@Qualifier("rabbitAdmin") AmqpAdmin rabbitAdmin) {
        Queue queue = QueueBuilder
                .durable(DOCUMENT_CREATE_EXCEL_QUEUE)
                .build();
        queue.setAdminsThatShouldDeclare(rabbitAdmin);
        return queue;
    }

    @Bean
    Binding documentCreatePDFBinding(Queue documentCreatePdfQueue,
                                     DirectExchange documentCreateDirectExchange) {
        return BindingBuilder.bind(documentCreatePdfQueue)
                .to(documentCreateDirectExchange)
                .with(DocumentType.PDF);
    }

    @Bean
    Binding documentCreateWordBinding(Queue documentCreateWordQueue,
                                      DirectExchange documentCreateDirectExchange) {
        return BindingBuilder.bind(documentCreateWordQueue)
                .to(documentCreateDirectExchange)
                .with(DocumentType.WORD);
    }

    @Bean
    Binding documentCreateExcelBinding(Queue documentCreateExcelQueue,
                                       DirectExchange documentCreateDirectExchange) {
        return BindingBuilder.bind(documentCreateExcelQueue)
                .to(documentCreateDirectExchange)
                .with(DocumentType.EXCEL);
    }

}
