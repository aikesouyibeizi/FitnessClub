package com.briup.sports.service.impl;

import com.briup.sports.bean.Weight;
import com.briup.sports.bean.WeightExample;
import com.briup.sports.mapper.WeightMapper;
import com.briup.sports.service.IWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightServiceImpl implements IWeightService {
    @Autowired
    private WeightMapper weightMapper;

    @Override
    public void insertWeight(Weight w) {
        System.out.println("insertWeight Service:"+w);
        String weightId = w.getWeightId();
        System.out.println(weightId);
        if(weightId!=null){
            Weight weight = this.findWeightById(weightId);
            System.out.println("insertWeight Service2222:"+weight);
            if(weight == null){
                weightMapper.insert(w);
            }else{
                updateWeight(w);
            }
        }else{
            weightMapper.insert(w);
        }

    }

    @Override
    public void updateWeight(Weight w) {
        Weight weight = findWeightById(w.getWeightId());

        if(weight == null){
            insertWeight(w);
        }else{
            WeightExample example = new WeightExample();
            example.createCriteria().andWeightIdEqualTo(w.getWeightId());
            weightMapper.updateByExample(w,example);
        }
    }

    @Override
    public Weight findWeightById(String id) {
        System.out.println("findWeightById:"+id);
        WeightExample example = new WeightExample();
        example.createCriteria().andWeightIdEqualTo(id);
        List<Weight> weights = weightMapper.selectByExample(example);
        if (weights.size()==0){
            return null;
        }else{
            return weights.get(0);
        }

    }

    @Override
    public List<String> findAllDays() {
        System.out.println("进到getXDays Service层");
        WeightExample example = new WeightExample();
        List<Weight> weights = weightMapper.selectByExample(example);
        List<String> list = new ArrayList<String>();
        for (Weight weight:weights) {
            list.add(weight.getWeightDate());

        }
//        int size = list.size();
//        for (int i=0;i<list.size()+1;i++) {
//            System.out.print(list.get(i)+"\t");
//        }
//        System.out.println("getXDays===="+list);
        return list;
    }

    @Override
    public List<String> findAllWeights() {
        System.out.println("进到getYWeights Service层");
        WeightExample example = new WeightExample();
        List<Weight> weights = weightMapper.selectByExample(example);
        List<String> list = new ArrayList<String>();
        for (Weight w:weights) {
            list.add(String.valueOf(w.getWeightNum()));
        }
//        Double max = Collections.max(list);
//        Double min = Collections.min(list);
//        int ma = new Double(max).intValue();
//        int mi = new Double(min).intValue();

//        List<String> arrayList = new ArrayList<>();
//        for (int i=(mi-2);i<(ma+3);i++){
//            arrayList.add(String.valueOf(i));
//
//        }


//        for (int i=0;i<arrayList.size()+1;i++) {
//            System.out.print(arrayList.get(i)+"\t");
//        }
//        System.out.println("getYWeights===="+arrayList);

        return list;
    }


}
