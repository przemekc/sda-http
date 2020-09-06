package pl.yellowduck.rd.apicontent;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
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

  @PostMapping
  public ResponseEntity<String> save(String string) {
    return ResponseEntity.ok("OK");
  }

  @RequestMapping(value = "/cv", method = RequestMethod.GET)
  public ResponseEntity<FileSystemResource> downloadStuff()
      throws IOException {
    File file = new File("/home/przemekc/cv.pdf");
    long fileLength = file.length();

    HttpHeaders respHeaders = new HttpHeaders();
    respHeaders.setContentType(MediaType.APPLICATION_PDF);
    respHeaders.setContentLength(fileLength);
    respHeaders.setContentDispositionFormData("attachment", "cv.pdf");

    return new ResponseEntity<FileSystemResource>(
        new FileSystemResource(file), respHeaders, HttpStatus.OK
    );
  }
}
