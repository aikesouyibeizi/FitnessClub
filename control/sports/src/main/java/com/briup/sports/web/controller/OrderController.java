package com.briup.sports.web.controller;


import com.briup.sports.bean.Order;
import com.briup.sports.config.Message;
import com.briup.sports.config.MessageUtil;
import com.briup.sports.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation("Order插入接口")
    @ResponseBody
    @RequestMapping(value = "/insertOrder", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message insertOrder(Order order){
        try{
//            System.out.println("insertOrder==============:"+order);
            System.out.println(order);
            int i = orderService.insertOrder(order);
            return MessageUtil.success("购买成功");
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("AllOrders查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAllOrders", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAllOrders(String id){
        try{
            System.out.println("findAllOrders==============:");
            List<Order> allOrders = orderService.findAllOrders(Integer.parseInt(id));
            return MessageUtil.success(allOrders);
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}
