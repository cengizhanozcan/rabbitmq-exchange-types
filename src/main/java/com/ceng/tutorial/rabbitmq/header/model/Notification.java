package com.ceng.tutorial.rabbitmq.header.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String text;

    private Platform platform;

    private Device device;

    private String color;

    private Integer duration = Integer.valueOf(1000);
}
