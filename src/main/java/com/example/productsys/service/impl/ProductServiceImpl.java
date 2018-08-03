package com.example.productsys.service.impl;

import com.example.productsys.dao.OrdersMapper;
import com.example.productsys.dao.ProductMapper;
import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import com.example.productsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    //id查询
    @Override
    public Product getByProductId(int productId){
        Product product=productMapper.selectByPrimaryKey(productId);
        return product;

    }

    //查询所有
    @Override
    public List<Product> selectAll() {
        List<Product> results=productMapper.selectAll();
        return results;
    }

    //插入
    @Override
    public int insertProduct(int productId, String productName, double productPrice) {
        productMapper.insert(productId, productName, productPrice);
        return productId;
    }

    //删除
    @Override
    public int deleteByProductId(int productId) {
        productMapper.delete(productId);
        return 0;
    }

    //更新
    @Override
    public int updateByProductId(int productId, String productName, double productPrice) {
        productMapper.update(productId, productName, productPrice);
        return productId;
    }
}
