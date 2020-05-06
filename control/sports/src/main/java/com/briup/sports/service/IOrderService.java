package com.briup.sports.service;

import com.briup.sports.bean.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    public int insertOrder(Order order);
    public List<Order> findAllOrders(Integer id);
}
