package com.troy.hanguang.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    public String name;
    public String id;
    public double price;

}
