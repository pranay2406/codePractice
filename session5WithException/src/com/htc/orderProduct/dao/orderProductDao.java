package com.htc.orderProduct.dao;

import java.util.List;

import com.htc.orderProduct.Exception.OrderManagementException;
import com.htc.orderProduct.entity.OrderProduct;
import com.htc.orderProduct.entity.Product;

public interface orderProductDao {
    public String addOrder(OrderProduct orderproduct) throws OrderManagementException;
    public List<Product> findAllProductByOrderId(String orderId) throws OrderManagementException;
    public String deleteOrderedProduct(String orderid,Product product) throws OrderManagementException;
    public String updateProductQuantity(String orderid, Product product) throws OrderManagementException;

}
