package com.briup.sports.service.impl;

import com.briup.sports.bean.Order;
import com.briup.sports.bean.OrderExample;
import com.briup.sports.mapper.OrderMapper;
import com.briup.sports.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        OrderExample example = new OrderExample();


//        example.createCriteria().andAddrIdEqualTo(order.getOrderId());
        int i = orderMapper.insert(order);
        return i;
    }

    @Override
    public List<Order> findAllOrders(Integer id) {
        OrderExample example = new OrderExample();
        example.createCriteria().andMemberIdEqualTo(id);
        List<Order> orders = orderMapper.selectByExample(example);
        return orders;
    }
}
