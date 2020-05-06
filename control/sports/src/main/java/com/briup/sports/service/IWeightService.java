package com.briup.sports.service;

import com.briup.sports.bean.Weight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWeightService {
    public void insertWeight(Weight w);
    public void updateWeight(Weight w);
    public Weight findWeightById(String id);
    public List<String> findAllDays();
    public List<String> findAllWeights();
}
