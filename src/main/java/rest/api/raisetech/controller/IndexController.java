package rest.api.raisetech.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rest.api.raisetech.domain.CreateForm;

import java.net.URI;
import java.util.List;

@RestController
public class IndexController {

    //    GET
    @GetMapping("/names")
    public List<String> getName(){
        return List.of("Okada_GET","Takahiro_GET");
    }

    //    POST
    @PostMapping("/names")
    public ResponseEntity<String> createName(@RequestBody CreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created!!");
    }

}