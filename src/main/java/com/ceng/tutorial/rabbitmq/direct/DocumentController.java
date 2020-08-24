package com.ceng.tutorial.rabbitmq.direct;

import com.ceng.tutorial.rabbitmq.direct.model.DocumentCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void create(@RequestBody DocumentCreateRequest request) {
        documentService.create(request);
    }

}
