package com.example.productsys.entity;

import org.springframework.stereotype.Component;

@Component
public class Orders {
    private int orderId;
    private int orderBuyerId;
    private int orderProductId;
    private double orderConsumption;
    private int  orderPayStatus;

    public int getOrderPayStatus() {
        return orderPayStatus;
    }

    public void setOrderPayStatus(int orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderBuyerId() {
        return orderBuyerId;
    }

    public void setOrderBuyerId(int orderBuyerId) {
        this.orderBuyerId = orderBuyerId;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public double getOrderConsumption() {
        return orderConsumption;
    }

    public void setOrderConsumption(double orderConsumption) {
        this.orderConsumption = orderConsumption;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderBuyerId=" + orderBuyerId +
                ", orderProductId=" + orderProductId +
                ", orderConsumption=" + orderConsumption +
                ", orderPayStatus=" + orderPayStatus +
                '}';
    }
}
