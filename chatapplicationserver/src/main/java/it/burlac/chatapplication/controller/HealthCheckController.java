package it.burlac.chatapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = "/healthCheck")
    public ResponseEntity<Boolean> getHealth(){
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
