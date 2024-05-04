package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
public class EntryController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${toDoServiceUri}")
    private String toTdoServiceUri;

    @RequestMapping(value = "/fetchToDos", method = RequestMethod.GET)
    ResponseEntity<?> todos() {
        List list = restTemplate.getForObject(
                toTdoServiceUri + "/fetchToDos", List.class);
        return ResponseEntity.status(HttpStatus.OK)
                .body(list);
    }

    @RequestMapping(value = "/addToDo", method = RequestMethod.GET)
    ResponseEntity<?> todos(@RequestParam String msg) {
        restTemplate.getForObject(
                toTdoServiceUri + "/addToDo?msg=" + msg, String.class);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Saved");
    }
}
