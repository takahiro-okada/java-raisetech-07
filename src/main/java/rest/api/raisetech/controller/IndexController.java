package rest.api.raisetech.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.api.raisetech.domain.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Validated
public class IndexController {

  //    GET
  @GetMapping("/names")
  public List<String> getName() {
    return List.of("Okada_GET", "Takahiro_GET");
  }

  //    POST
  @PostMapping("/names")
  public ResponseEntity<String> createName(@RequestBody CreateForm form) {
    URI url = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/names/id").build()
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
  public ResponseEntity<Map<String, String>> deleteName(@PathVariable int id,
                                                        @RequestBody DeleteName names) {
    return ResponseEntity.ok(Map.of("message", "name successfully deleted!"));
  }

  //    GETでクエリ文字列を受け取る
  public static final String template = "吾輩は, %sである!";
  private static final String birthDateText = "誕生日は%s";
  private final AtomicLong counter = new AtomicLong();

  //    Validationの実装
  @GetMapping("/user")
  public User getUserInfo(@RequestParam(value = "name", defaultValue = "猫") String name,
                          @RequestParam(value = "birthdate", defaultValue = "20001212")
                          String birthdate) {
    return new User(counter.incrementAndGet(), String.format(template, name),
        String.format(birthDateText, birthdate));
  }

  //    Validationの実装
  @GetMapping("/country")
  public Country getCountry(
      @Valid @NotNull @Min(10) @Max(999) @RequestParam(value = "countrycode") Integer countrycode,
      @RequestParam(value = "countryname", defaultValue = "Japan") String countryName) {
    return new Country(countrycode, countryName);
  }

}