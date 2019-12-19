package com.troy.hanguang.service;

import com.troy.hanguang.entity.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientServiceFallbackFactory implements FallbackFactory<ProductClientService> {

    @Override
    public ProductClientService create(Throwable throwable) {
        return new ProductClientService() {
            @Override
            public Product add(Product productDto) {
                return null;
            }

            @Override
            public Product get(long id) {
                Product product = new Product();
                product.setId(String.valueOf(id));
                product.setName("没有该信息");
                return product;
            }

            @Override
            public List<Product> list() {
                return null;
            }
        };
    }
}
