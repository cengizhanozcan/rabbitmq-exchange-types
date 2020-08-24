package com.ceng.tutorial.rabbitmq.header.listener;

import com.ceng.tutorial.rabbitmq.header.model.Notification;

public class NotificationNotifyListener {

    protected void print(String listener, Notification notification) {
        StringBuffer buffer = new StringBuffer()
                .append("Listener: ")
                .append(listener)
                .append("\n")
                .append("Platform: ")
                .append(notification.getPlatform())
                .append("\n")
                .append("Text: ")
                .append(notification.getText())
                .append("\n")
                .append("Color: ")
                .append(notification.getColor())
                .append("\n")
                .append("Duration: ")
                .append(notification.getDuration())
                .append("\n");
        System.out.println(buffer.toString());
    }
}
