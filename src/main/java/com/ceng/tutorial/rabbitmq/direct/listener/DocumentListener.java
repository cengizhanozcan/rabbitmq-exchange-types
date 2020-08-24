package com.ceng.tutorial.rabbitmq.direct.listener;

import com.ceng.tutorial.rabbitmq.direct.model.Document;

public class DocumentListener {

    protected void print(Document document) {
        System.out.println("------------------");
        System.out.println("Document Type: " + document.getDocumentType());
        System.out.println("Name: " + document.getName());
        System.out.println("Description: " + document.getDescription());
    }
}
