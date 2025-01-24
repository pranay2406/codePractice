package com.htc.orderProduct.ServiceIMPL;

import java.util.List;

import com.htc.orderProduct.Exception.OrderManagementException;
import com.htc.orderProduct.Service.OrderProductService;
import com.htc.orderProduct.dao.orderProductDao;
import com.htc.orderProduct.daoIMPL.orderProductDaoImpl;
import com.htc.orderProduct.entity.OrderProduct;
import com.htc.orderProduct.entity.Product;

public class OrderProductServiceImpl implements OrderProductService{
	 
	private orderProductDao orderproductdao = new orderProductDaoImpl();

	@Override
	public String addOrder(OrderProduct orderproduct) {
          try {
			return orderproductdao.addOrder(orderproduct);
		} catch (OrderManagementException e) {
			System.err.println(e.getStackTrace()+" Error Message:---- "+e.getErrorMessage());
			return "unable to make add Order";
		}
	}

	@Override
	public List<Product> findAllProductByOrderId(String orderId) {
		try {
			return orderproductdao.findAllProductByOrderId(orderId);
		} catch (OrderManagementException e) {
			System.err.println(e.getStackTrace()+" Error Message:---- "+e.getErrorMessage());
			return null;
		}
	}

	@Override
	public String deleteOrderedProduct(String orderid, Product product) {
		try {
			return orderproductdao.deleteOrderedProduct(orderid, product);
		} catch (OrderManagementException e) {
			System.err.println(e.getStackTrace()+" Error Message:---- "+e.getErrorMessage());
			return "unable to delete product";
		}
	}

	@Override
	public String updateProductQuantity(String orderid, Product product) {
		try {
			return orderproductdao.updateProductQuantity(orderid, product);
		} catch (OrderManagementException e) {
			System.err.println(e.getStackTrace()+" Error Message "+e.getErrorMessage());
			return "unable to delete product";
		}
	}
				
}
