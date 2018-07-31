package com.dieboldnixdorf;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-b-ms")
public class ServiceBController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "errorFalback")
    public ResponseEntity<Status> getStatusServiceB() {
        return new ResponseEntity<>(new Status("UP", "client2"), HttpStatus.OK);
    }

    @RequestMapping(value = "/methodA", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodAServiceB() {
        System.out.println("service-b-ms/methodA");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodB", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodBServiceB() {
        System.out.println("service-b-ms/methodB");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public ResponseEntity<String> defaultErrorFalback() {
        return new ResponseEntity<>("<== Error ==>", HttpStatus.FAILED_DEPENDENCY);
    }

    public ResponseEntity<Status> errorFalback() {
        return new ResponseEntity<>(new Status("DOWN", "client1"), HttpStatus.OK);
    }

}
