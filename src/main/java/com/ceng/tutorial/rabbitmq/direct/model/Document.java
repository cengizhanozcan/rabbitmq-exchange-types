package com.ceng.tutorial.rabbitmq.direct.model;

import com.ceng.tutorial.rabbitmq.direct.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    private String name;

    private String description;

    private DocumentType documentType;
}
