package com.troy.hanguang.sysservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.troy.hanguang.sysservice.bean.SysUser;
import com.troy.hanguang.sysservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "getUserByLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public SysUser login(String phone, String password) {
        SysUser sysUserDto = new SysUser();
        sysUserDto.setLoginName("admin");
        sysUserDto.setPassword("admin");

        SysUser result = sysUserService.getUserByPassword(sysUserDto);
        return result;
    }

    /**
     * hystrix服务熔断
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "getUserList", method = {RequestMethod.GET, RequestMethod.POST})
    @HystrixCommand(fallbackMethod = "processHystrixUserList")
    public SysUser getUserList(String phone, String password) {
        SysUser sysUserDto = new SysUser();
        sysUserDto.setLoginName("admin");
        sysUserDto.setPassword("admin");

        if (1 == 1){
            throw new RuntimeException("没有改信息");
        }

        SysUser result = sysUserService.getUserByPassword(sysUserDto);
        return result;
    }

    public SysUser processHystrixUserList(@PathVariable("loginName")String loginName,@PathVariable("password")String password){
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(loginName);
        sysUser.setPassword("密码错误");
        return sysUser;
    }

}
