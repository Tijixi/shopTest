package com.example.productsys.service;

import com.example.productsys.entity.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;

    @Test
    public void getByOrderId() {

        ordersService.getByOrderId(1).toString();

    }

    @Test
    public void selectAll() {
        List<Orders> results=ordersService.selectAll();
        for(Orders item:results)            //打印输出list集合，该方法适用于所有collection集合
        {
            item.toString();
        }
    }

    @Test
    public void insertOrder() {
        int i=ordersService.insertOrder(8,3,1,80,1);
        assertEquals(8,i);
    }

    @Test
    public void deleteByOrderId() {

        ordersService.deleteByOrderId(5);
        List<Orders> results=ordersService.selectAll();
        for (Orders item:results){

            item.toString();
        }
    }

    @Test
    public void updateByOrderId() {
        ordersService.updateByOrderId(1,1,1,80,0);
        ordersService.getByOrderId(1).toString();
    }
}