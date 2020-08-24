package com.ceng.tutorial.rabbitmq.direct.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentCreateRequest {

    private String name;

    private String description;

    private DocumentType documentType;

    public Document convert() {
        return Document.builder()
                .name(this.name)
                .description(this.description)
                .documentType(this.documentType != null ? this.documentType : DocumentType.PDF)
                .build();

    }

}
