package com.ceng.tutorial.rabbitmq.topic.listener;

import com.ceng.tutorial.rabbitmq.topic.model.DataCenter;

public class DataCenterListener {

    protected void print(String location, DataCenter dataCenter) {
        StringBuffer buffer = new StringBuffer()
                .append("Data Center Location: ")
                .append(location)
                .append("\n")
                .append("Name: ")
                .append(dataCenter.getName())
                .append("\n")
                .append("Path: ")
                .append(dataCenter.getPath())
                .append("\n");
        System.out.println(buffer.toString());
    }
}
