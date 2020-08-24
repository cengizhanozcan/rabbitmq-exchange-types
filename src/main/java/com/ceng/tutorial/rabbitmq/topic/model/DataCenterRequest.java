package com.ceng.tutorial.rabbitmq.topic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataCenterRequest {

    private String name;

    private String path;

    public DataCenter convert() {
        return DataCenter
                .builder()
                .name(this.name)
                .path(this.path)
                .build();
    }

}
