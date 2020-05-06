package com.briup.sports.service.impl;

import com.briup.sports.bean.Addr;
import com.briup.sports.bean.AddrExample;
import com.briup.sports.mapper.AddrMapper;
import com.briup.sports.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrServiceImpl implements IAddrService {

    @Autowired
    private AddrMapper addrMapper;

    @Override
    public List<Addr> findAllAddrs() {
        AddrExample example = new AddrExample();
        List<Addr> addrs = addrMapper.selectByExample(example);
        return addrs;
    }

    @Override
    public Addr findAddrById(int id) {
        AddrExample example = new AddrExample();
        example.createCriteria().andAddrIdEqualTo(id);
        List<Addr> addrs = addrMapper.selectByExample(example);

        return addrs.get(0);
    }

    @Override
    public int updateAddr(Addr addr) {
        AddrExample example = new AddrExample();
        example.createCriteria().andAddrIdEqualTo(addr.getAddrId());
        int i = addrMapper.updateByExample(addr, example);
        return i;
    }


}
