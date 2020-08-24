package com.ceng.tutorial.rabbitmq.header.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {

    private String text;
    private Platform platform;
    private Device device;

    public Notification convert() {
        return Notification
                .builder()
                .text(this.text)
                .platform(this.platform)
                .device(this.device)
                .color("RED")
                .build();
    }
}
