package com.example.productsys.service.impl;

import com.example.productsys.dao.OrdersMapper;
import com.example.productsys.entity.Orders;
import com.example.productsys.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    //通过id查询
    @Override
    public Orders getByOrderId(int ordersId){
        Orders orders=ordersMapper.selectByPrimaryKey(ordersId);
        return orders;
    }

    //查询所有
    public List<Orders> selectAll(){
        List<Orders> results=ordersMapper.selectAll();
        return results;
    }

    //插入
    @Override
    public int insertOrder(int orderId, int orderBuyerId, int orderProductId, double orderConsumption,int orderPayStatus) {
       ordersMapper.insert(orderId,orderBuyerId,orderProductId,orderConsumption,orderPayStatus);
       return orderId;
    }

    //删除
    @Override
    public void deleteByOrderId(int orderId) {
        ordersMapper.delete(orderId);
    }

    //更新
    @Override
    public int updateByOrderId(int orderId, int orderBuyerId, int orderProductId, double orderConsumption,int orderPayStatus) {
        ordersMapper.update(orderId,orderBuyerId,orderProductId,orderConsumption,orderPayStatus);
        return orderId;
    }

}
