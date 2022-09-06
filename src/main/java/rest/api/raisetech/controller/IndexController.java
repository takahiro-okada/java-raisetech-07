package rest.api.raisetech.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    //    GET
    @GetMapping("/names")
    public List<String> getName(){
        return List.of("Okada_GET","Takahiro_GET");
    }
}