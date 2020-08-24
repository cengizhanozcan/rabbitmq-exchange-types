package com.ceng.tutorial.rabbitmq.topic;

import com.ceng.tutorial.rabbitmq.direct.DocumentService;
import com.ceng.tutorial.rabbitmq.direct.model.DocumentCreateRequest;
import com.ceng.tutorial.rabbitmq.topic.model.DataCenterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data-center")
public class DataCenterController {

    private final DataCenterService dataCenterService;

    public DataCenterController(DataCenterService dataCenterService) {
        this.dataCenterService = dataCenterService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void complete(@RequestBody DataCenterRequest request) {
        dataCenterService.complete(request);
    }

}
