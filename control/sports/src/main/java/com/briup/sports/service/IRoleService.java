package com.briup.sports.service;

import com.briup.sports.bean.Role;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {
    public int inserRole(Role role);
}
