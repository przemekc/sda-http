package pl.yellowduck.rd.apicontent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

  @GetMapping(produces = {"application/json", "application/xml"})
  public List<Person> getPersonsJson() {
    return List.of(
        new Person("Jan", "Kowalski"),
        new Person("Anna", "Nowak")
    );
  }
}
