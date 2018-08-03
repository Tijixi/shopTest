package com.example.productsys.service;

import com.example.productsys.entity.Orders;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrdersService {
/*
     CRUD的四个接口
*/
     //id查询
     Orders getByOrderId(int orderId);

     //查询所有
     List<Orders> selectAll();

     //插入
     int   insertOrder(int orderId, int orderBuyerId,int orderProductId, double orderConsumption,int orderPayStatus);

     //删除
     void  deleteByOrderId(int orderId);

     //更新
     int updateByOrderId(int orderId, int orderBuyerId,int orderProductId, double orderConsumption,int orderPayStatus);


}

