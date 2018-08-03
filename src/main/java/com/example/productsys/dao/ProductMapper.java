package com.example.productsys.dao;

import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ProductMapper {

    //插入操作
    @Insert("INSERT INTO product(product_id, product_name, product_price) " +
            "VALUES(#{productId}, #{productName},#{productPrice})")
    int insert(@Param("productId") int productId,@Param("productName") String productName,
               @Param("productPrice") double productPrice);

    //更新
    @Update("UPDATE product SET product_id=#{productId}, product_name=#{productName}, product_price=#{productPrice}"+
            "WHERE product_id=#{productId}")
    int update(@Param("productId") int productId,@Param("productName") String productName,
               @Param("productPrice") double productPrice);

    //id查询
    @Select("SELECT * FROM product WHERE product_id=#{productId}")
    @Results({
            @Result(property = "productId", column = "product_id", javaType = Integer.class),
            @Result(property = "productName", column = "product_name", javaType = String.class),
            @Result(property = "productPrice", column = "product_price", javaType = Integer.class)
    })
    Product selectByPrimaryKey(@Param("productId") int  productId);

    //查询所有
    @Select("SELECT * FROM product")
    @Results({
            @Result(property = "productId", column = "product_id", javaType = Integer.class),
            @Result(property = "productName", column = "product_name", javaType = String.class),
            @Result(property = "productPrice", column = "product_price", javaType = Integer.class)
    })
    List<Product> selectAll();

    //删除
    @Delete("DELETE FROM product WHERE product_id=#{productId}")
    int delete(int orderId);

}
