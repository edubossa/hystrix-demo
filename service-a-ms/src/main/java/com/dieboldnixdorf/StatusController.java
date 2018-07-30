package com.dieboldnixdorf;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @HystrixCommand(commandKey = "status", groupKey = "Client 01", fallbackMethod = "errorFalback")
    public ResponseEntity<Status> getStatus() {
        System.out.println("service-a-ms/status");
        return new ResponseEntity<>(new Status("UP", "client1"), HttpStatus.OK);
    }

    public ResponseEntity<Status> errorFalback() {
        return new ResponseEntity<>(new Status("DOWN", "client1"), HttpStatus.OK);
    }

}
