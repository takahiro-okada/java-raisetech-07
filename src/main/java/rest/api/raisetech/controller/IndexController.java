package rest.api.raisetech.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.api.raisetech.domain.CreateForm;
import rest.api.raisetech.domain.DeleteName;
import rest.api.raisetech.domain.UpdateName;

import java.net.URI;
import java.util.List;
import java.util.Map;

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

    //    PATCH
    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String,String>> updateName(@PathVariable int id, @RequestBody UpdateName names){
        return ResponseEntity.ok(Map.of("message","name successfully updated!!"));
    }

    //    DELETE
    @DeleteMapping("names/{id}")
    public ResponseEntity<Map<String,String>> deleteName(@PathVariable int id, @RequestBody
    DeleteName names){
        return ResponseEntity.ok(Map.of("message","name successfully deleted!"));
    }

}