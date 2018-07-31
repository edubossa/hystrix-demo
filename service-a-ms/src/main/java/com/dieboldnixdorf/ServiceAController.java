package com.dieboldnixdorf;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-a-ms")
public class ServiceAController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "errorFalback")
    public ResponseEntity<Status> getStatus() {
        System.out.println("service-a-ms/status");
        return new ResponseEntity<>(new Status("UP", "client1"), HttpStatus.OK);
    }

    public ResponseEntity<Status> errorFalback() {
        return new ResponseEntity<>(new Status("DOWN", "client1"), HttpStatus.OK);
    }

    @RequestMapping(value = "/methodA", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodA() {
        System.out.println("service-a-ms/methodA");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodB", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodB() {
        System.out.println("service-a-ms/methodB");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodC", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodC() {
        System.out.println("service-a-ms/methodC");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodD", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodD() {
        System.out.println("service-a-ms/methodD");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public ResponseEntity<String> defaultErrorFalback() {
        return new ResponseEntity<>("<== Error ==>", HttpStatus.FAILED_DEPENDENCY);
    }

}
