package com.dieboldnixdorf.apimobile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {

    @Autowired
    private ServiceAFeingclient serviceAFeingclient;


    @RequestMapping(method = RequestMethod.GET, path = "/status/all")
    @HystrixCommand(fallbackMethod = "errorFallback")
    public ResponseEntity<Status> getAllStatus() {
        System.out.println("MobileController.getAllStatus");
        String statusServiceA = this.serviceAFeingclient.getStatusServiceA();
        System.out.println(statusServiceA);
        return new ResponseEntity<>(new Status("UP", "ALL SERVICES"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/status/servicea")
    @HystrixCommand(fallbackMethod = "errorFallback")
    public ResponseEntity<Status> getStatusServiceA() {
        //Status statusServiceA = this.serviceAFeingclient.getStatusServiceA();
        return new ResponseEntity<>(new Status("UP", "EWS"), HttpStatus.OK);
    }


    public ResponseEntity<Status> errorFallback() {
        return new ResponseEntity<>(new Status("DOWN", "ERROR SERVICES"), HttpStatus.METHOD_FAILURE);
    }

}
