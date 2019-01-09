package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("book-api")
public interface BookClient {

    @RequestMapping(method = GET, value = "/greeting")
    String getGreeting();
}
