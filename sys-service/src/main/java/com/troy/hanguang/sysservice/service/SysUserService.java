package com.troy.hanguang.sysservice.service;

import com.troy.hanguang.sysservice.bean.SysUser;
import org.springframework.stereotype.Service;

@Service
public interface SysUserService {

    public SysUser getUserByPassword(SysUser sysUser);
}
