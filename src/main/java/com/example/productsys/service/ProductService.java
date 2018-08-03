package com.example.productsys.service;

import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
/*
     CRUD的四个接口
*/

    //id查询
    Product getByProductId(int productId);

    //查询所有
    List<Product> selectAll();

    //插入
    int  insertProduct(int productId, String  productName,double productPrice);

    //删除
    int  deleteByProductId(int productId);

    //更新
    int updateByProductId(int productId, String  productName,double productPrice);
}
