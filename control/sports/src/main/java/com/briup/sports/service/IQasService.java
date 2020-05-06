package com.briup.sports.service;

import com.briup.sports.bean.Qas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IQasService {
    public Qas findQasById(int id);
    public List<Qas> findAllQas();
}
