package com.example.productsys.service;

import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private  ProductService productService;

    @Test
    public void getByProductId() {
        System.out.println(productService);
        /*Product product=productService.getByProductId(1);
        System.out.println(product);*/
       // productService.getByProductId(1).toString();
    }

    @Test
    public void selectAll() {
        productService.selectAll();
        List<Product> results=productService.selectAll();
        for(Product item:results)            //打印输出list集合，该方法适用于所有collection集合
        {
            item.toString();
        }
    }

    @Test
    public void insertProduct() {
        int i= productService.insertProduct(2,"测试添加商品2",20);
        assertEquals(2,i);

    }

    @Test
    public void deleteByProductId() {
        int i= productService.deleteByProductId(3);
        productService.getByProductId(i).toString();
    }

    @Test
    public void updateByProductId() {
        int i= productService.updateByProductId(2,"修改后商品2",20);
        productService.getByProductId(i).toString();
    }
}