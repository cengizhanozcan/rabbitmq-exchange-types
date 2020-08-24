package com.ceng.tutorial.rabbitmq.fanout.listener;

import com.ceng.tutorial.rabbitmq.fanout.model.GameObject;

public class GameObjectCreateClientListener {

    protected void print(String clientName, GameObject gameObject) {
        StringBuffer buffer = new StringBuffer()
                .append("Client Name: ")
                .append(clientName)
                .append("\n")
                .append("Shape Type: ")
                .append(gameObject.getShape())
                .append("\n")
                .append("Label: ")
                .append(gameObject.getLabel())
                .append("\n")
                .append("Vector: ")
                .append(gameObject.getVector().toString())
                .append("\n");
        System.out.println(buffer.toString());
    }
}
