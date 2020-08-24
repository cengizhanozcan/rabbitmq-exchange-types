package com.ceng.tutorial.rabbitmq.fanout.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameObject implements Serializable {

    private String label;

    private ShapeType shape;

    private Vector vector;

}
