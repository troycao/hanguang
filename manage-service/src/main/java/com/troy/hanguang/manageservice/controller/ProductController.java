package com.troy.hanguang.manageservice.controller;

import com.troy.hanguang.entity.Product;
import com.troy.hanguang.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/product")
public class ProductController {

    //单机
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //微服务
    private static final String REST_URL_PREFIX = "http://SYS-SERVICE";

    @Autowired
    ProductClientService productClientService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET})
    public Product getProduct(@PathVariable("id") Long id){
        Product product = productClientService.get(id);
        return product;
    }


}
