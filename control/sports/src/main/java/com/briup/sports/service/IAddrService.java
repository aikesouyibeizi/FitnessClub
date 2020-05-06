package com.briup.sports.service;

import com.briup.sports.bean.Addr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddrService {
    public List<Addr> findAllAddrs();
    public Addr findAddrById(int id);
    public int updateAddr(Addr addr);
}
