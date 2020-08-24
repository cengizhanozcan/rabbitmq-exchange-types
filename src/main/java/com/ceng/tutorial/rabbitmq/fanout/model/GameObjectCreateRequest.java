package com.ceng.tutorial.rabbitmq.fanout.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameObjectCreateRequest {

    private String label;

    private ShapeType shapeType;

    private double x;

    private double y;

    private double z;

    public GameObject convert() {
        return GameObject.builder()
                .label(this.label)
                .shape(this.shapeType)
                .vector(convertVector())
                .build();

    }

    private Vector convertVector() {
        return Vector.builder()
                .x(this.x)
                .y(this.y)
                .z(this.z)
                .build();
    }
}
