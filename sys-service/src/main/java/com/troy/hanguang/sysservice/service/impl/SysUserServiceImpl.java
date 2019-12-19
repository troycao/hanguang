package com.troy.hanguang.sysservice.service.impl;

import com.troy.hanguang.sysservice.bean.SysUser;
import com.troy.hanguang.sysservice.bean.SysUserExample;
import com.troy.hanguang.sysservice.dao.SysUserMapper;
import com.troy.hanguang.sysservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByPassword(SysUser sysUserDto) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andLoginNameEqualTo(sysUserDto.getLoginName());

        SysUser sysUser = null;
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers!= null){
            sysUser = sysUsers.get(0);
        }
        return sysUser;
    }
}
