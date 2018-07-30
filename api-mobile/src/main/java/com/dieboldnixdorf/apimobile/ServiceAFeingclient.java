package com.dieboldnixdorf.apimobile;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-a-ms")
public interface ServiceAFeingclient {

    @RequestMapping(method = RequestMethod.GET, path = "/service-a-ms/status")
    String getStatusServiceA();

}
