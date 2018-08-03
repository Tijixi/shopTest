package com.example.productsys.dao;



import com.example.productsys.entity.Orders;
import com.sun.tools.javac.comp.Flow;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.type.JdbcType;

import java.sql.JDBCType;
import java.util.List;

@Mapper
public interface OrdersMapper {

    /*
    注意：函数中传参需要加上@Param绑定参数才能成功，否则会报参数绑定失败的错误，此错误限于多个参数传递，单个好像不用
    * */

    //注意：小写的flow_item_id 是数据库中的表中的字段名，下面21行的大写的flow_item_Id是在实体类FlowItem中声明的私有属性的属性名，注意区分

    //orders中插入数据
    @Insert("INSERT INTO orders(order_id, order_buyer_id, order_product_id, order_consumption, order_pay_status) " +
            "VALUES(#{orderId}, #{orderBuyerId},#{orderProductId},#{orderConsumption},#{orderPayStatus})")
    int insert(@Param("orderId") int orderId,@Param("orderBuyerId") int orderBuyerId,
                  @Param("orderProductId") int orderProductId,@Param("orderConsumption") double orderConsumption,
               @Param("orderPayStatus") int orderPayStatus);

    //更新数据
    @Update("UPDATE orders SET order_id=#{orderId}, order_buyer_id=#{orderBuyerId}, order_product_id=#{orderProductId}, order_consumption=#{orderConsumption},"+
            "order_pay_status=#{orderPayStatus} WHERE order_id=#{orderId}")
    //  int update(Orders orders);
    int update(@Param("orderId") int orderId,@Param("orderBuyerId") int orderBuyerId,
    @Param("orderProductId") int orderProductId,@Param("orderConsumption") double orderConsumption,@Param("orderPayStatus") int orderPayStatus);

    //根据id查询
    @Select("SELECT * FROM orders WHERE order_id=#{orderId}")
    @Results({
            @Result(property = "orderId", column = "order_id", javaType = Integer.class),
            @Result(property = "orderBuyerId", column = "order_buyer_id", javaType = Integer.class),
            @Result(property = "orderProductId", column = "order_product_id", javaType = Integer.class),
            @Result(property = "orderConsumption", column = "order_consumption", javaType = Integer.class),
            @Result(property = "orderPayStatus", column = "order_pay_status", javaType = Integer.class)
    })
    Orders selectByPrimaryKey(@Param("orderId") int  orderId);

    //查询所有
    @Select("SELECT * FROM orders")
    @Results({
            @Result(property = "orderId", column = "order_id", javaType = Integer.class),
            @Result(property = "orderBuyerId", column = "order_buyer_id", javaType = Integer.class),
            @Result(property = "orderProductId", column = "order_product_id", javaType = Integer.class),
            @Result(property = "orderConsumption", column = "order_consumption", javaType = Integer.class),
            @Result(property = "orderPayStatus", column = "order_pay_status", javaType = Integer.class)
    })
    List<Orders> selectAll();


    //删除操作
    @Delete("DELETE FROM orders WHERE order_id=#{orderId}")
    void delete(int orderId);



}
