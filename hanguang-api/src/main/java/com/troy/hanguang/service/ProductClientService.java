package com.troy.hanguang.service;

import com.troy.hanguang.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "SYS-SERVICE", fallbackFactory = ProductClientServiceFallbackFactory.class)
public interface ProductClientService {

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public Product add(Product productDto);

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id")long id);

    @RequestMapping(value = "product/list", method = RequestMethod.GET)
    public List<Product> list();
}
