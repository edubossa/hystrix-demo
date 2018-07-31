package com.dieboldnixdorf;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-c-ms")
public class ServiceCController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "errorFalback")
    public ResponseEntity<Status> getStatusServiceC() {
        return new ResponseEntity<>(new Status("UP", "client3"), HttpStatus.OK);
    }

    public ResponseEntity<Status> errorFalback() {
        return new ResponseEntity<>(new Status("DOWN", "client1"), HttpStatus.OK);
    }

    @RequestMapping(value = "/methodA", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodAServiceC() {
        System.out.println("service-c-ms/methodA");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodB", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodBServiceC() {
        System.out.println("service-c-ms/methodB");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/methodC", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultErrorFalback")
    public ResponseEntity<String> methodCServiceC() {
        System.out.println("service-c-ms/methodC");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public ResponseEntity<String> defaultErrorFalback() {
        return new ResponseEntity<>("<== Error ==>", HttpStatus.FAILED_DEPENDENCY);
    }

}
