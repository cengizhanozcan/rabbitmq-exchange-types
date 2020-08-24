package com.ceng.tutorial.rabbitmq.topic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataCenter {

    private String name;

    private String path;

}
