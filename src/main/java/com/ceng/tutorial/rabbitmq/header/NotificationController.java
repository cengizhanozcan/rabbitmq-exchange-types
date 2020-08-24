package com.ceng.tutorial.rabbitmq.header;

import com.ceng.tutorial.rabbitmq.header.model.NotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody NotificationRequest request) throws JsonProcessingException {
        notificationService.notify(request);
    }
}
