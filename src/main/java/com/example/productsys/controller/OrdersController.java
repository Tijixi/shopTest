package com.example.productsys.controller;

import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import com.example.productsys.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/controller")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    //订单详情主页面
    @RequestMapping(value = "/orderHomePagectrl")
    public String orderHomepageftl(Map<String,Object> map) {
        List<Orders> results=ordersService.selectAll();
        map.put("ordersList", results);
        return "ordersHomePage";
    }

    @RequestMapping(value="/ordersctrl", method=RequestMethod.GET)
    public String say() {
        System.out.println(ordersService.getByOrderId(1));

        //insert方法已成功
        System.out.println(ordersService.getByOrderId(ordersService.insertOrder(5,7,4,33,0)));

        //删除
        ordersService.deleteByOrderId(2);

        //更新方法已实现，待会儿使用select all来实现输出
        ordersService.updateByOrderId(5,10,4,0, 1);

        //select all的方法调用
        List<Orders> results=ordersService.selectAll();
        for(Orders item:results)            //打印输出list集合，该方法适用于所有collection集合
        {
            System.out.println(item);
        }

        return null;
    }

}
