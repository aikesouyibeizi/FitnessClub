package com.briup.sports.service.impl;

import com.briup.sports.bean.Role;
import com.briup.sports.bean.RoleExample;
import com.briup.sports.mapper.RoleMapper;
import com.briup.sports.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int inserRole(Role role) {
        RoleExample example = new RoleExample();
        int j = roleMapper.insert(role);
        return j;
    }
}
