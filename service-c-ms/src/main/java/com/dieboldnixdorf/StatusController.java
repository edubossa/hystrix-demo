package com.dieboldnixdorf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResponseEntity<Status> getStatus() {
        return new ResponseEntity<>(new Status("UP", "client3"), HttpStatus.OK);
    }

}
