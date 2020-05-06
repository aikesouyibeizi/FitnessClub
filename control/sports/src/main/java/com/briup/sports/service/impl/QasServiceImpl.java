package com.briup.sports.service.impl;

import com.briup.sports.bean.Qas;
import com.briup.sports.bean.QasExample;
import com.briup.sports.mapper.QasMapper;
import com.briup.sports.service.IQasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QasServiceImpl implements IQasService {
    @Autowired
    private QasMapper qasMapper;
    @Override
    public Qas findQasById(int id) {
        QasExample example = new QasExample();
        example.createCriteria().andIdsEqualTo(id);
        List<Qas> qas = qasMapper.selectByExample(example);
        return qas.get(0);
    }

    @Override
    public List<Qas> findAllQas() {
        QasExample qasExample = new QasExample();
        List<Qas> qas = qasMapper.selectByExample(qasExample);
        return qas;
    }
}
