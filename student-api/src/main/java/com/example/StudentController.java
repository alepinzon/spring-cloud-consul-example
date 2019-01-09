package com.example;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class StudentController {

    private final BookClient bookClient;
    private final DiscoveryClient discoveryClient;

    public StudentController(BookClient bookClient, DiscoveryClient discoveryClient) {
        this.bookClient = bookClient;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(path = "/", method = GET)
    public String FeignGreeting() {
        return "Feign : " + bookClient.getGreeting();
    }

    @RequestMapping(path = "/instances/{serviceId}", method = GET)
    public List<ServiceInstance> serviceInstances(@PathVariable(value = "serviceId") String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }


}
