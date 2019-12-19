package com.troy.hanguang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SYS-SERVICE")
public interface OrderService {

    @RequestMapping(value = "/createorder", method = {RequestMethod.GET})
    public void createOrder();
}
