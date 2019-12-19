package com.troy.hanguang.manageservice.controller;

import com.troy.hanguang.entity.SysUser;
import com.troy.hanguang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/manage")
public class LoginController {

    //单机
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //微服务
    private static final String REST_URL_PREFIX = "http://SYS-SERVICE";

    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public SysUser login(@RequestParam(value = "userName")String userName,@RequestParam(value = "password")String password){
        SysUser sysUser = new SysUser();
        sysUser.setUsername(userName);
        sysUser.setPassword(password);

        SysUser sysUser1 = restTemplate.postForObject(REST_URL_PREFIX + "/sysUser/getUserByLogin", sysUser, SysUser.class);
        return sysUser1;
    }

    @RequestMapping(value = "/getUserList", method = {RequestMethod.GET, RequestMethod.POST})
    public SysUser getUserList(){
        SysUser sysUser = new SysUser();

        SysUser sysUser1 = restTemplate.postForObject(REST_URL_PREFIX + "/sysUser/getUserList", sysUser, SysUser.class);
        return sysUser1;
    }


}
