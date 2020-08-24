package com.ceng.tutorial.rabbitmq.fanout;

import com.ceng.tutorial.rabbitmq.fanout.model.GameObjectCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-object")
public class GameObjectController {

    private final GameObjectService gameObjectService;

    public GameObjectController(GameObjectService gameObjectService) {
        this.gameObjectService = gameObjectService;
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public void create(@RequestBody GameObjectCreateRequest request){
        gameObjectService.create(request);
    }

}
