package com.htc.orderProduct.daoIMPL;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.htc.orderProduct.Exception.OrderManagementException;
import com.htc.orderProduct.dao.orderProductDao;
import com.htc.orderProduct.entity.OrderProduct;
import com.htc.orderProduct.entity.Product;

public class orderProductDaoImpl implements orderProductDao{
		HashMap<String,List<Product>> ordermapProduct = new HashMap<>();
	
	@Override
	public String addOrder(OrderProduct orderproduct) throws OrderManagementException {
		    	  if(!ordermapProduct.containsKey(orderproduct.getOrderId())){
		    		   ordermapProduct.put(orderproduct.getOrderId(), orderproduct.getProductList());
		    		   return orderproduct.getOrderId() + " placed";
		    	   }
		    	   else{
		    		   throw new OrderManagementException("Sorry unable to place your order", LocalDateTime.now());
		    	   }
	}

	@Override
	public List<Product> findAllProductByOrderId(String orderId) throws OrderManagementException {
		
		       if(!ordermapProduct.isEmpty()) {
		    	   if(ordermapProduct.containsKey(orderId.toUpperCase())){
			    		List<Product> product = ordermapProduct.get(orderId);
			    		  if(!product.isEmpty()) {
			    			  return product;
			    		  }
			    		  else {
			    			  throw new OrderManagementException("product list is empty", LocalDateTime.now());
			    		  }
			    		  
			    	  }
		    	   else
		    	   {
		    		   throw new OrderManagementException("orderId not present", LocalDateTime.now());
		    	   }
		       }
		    	else{
		    		throw new OrderManagementException("Cart is Empty", LocalDateTime.now());
		    	}
			
	}

	@Override
	public String deleteOrderedProduct(String orderid, Product product) throws OrderManagementException {
		  		    if(ordermapProduct.containsKey(product)) {
		  		       return	ordermapProduct.get(orderid).remove(product)+" Removed.";
		  		    }
		  		    else {
		  		    	//throw new OrderManagementException("Sorry, Product not found in Cart!", LocalDateTime.now());
		  		    	throw new OrderManagementException("Cart is Empty", LocalDateTime.now());
		  		    }

	}

	@Override
	public String updateProductQuantity(String orderid, Product product) throws OrderManagementException {
		            if(ordermapProduct.containsKey(orderid)){
		            	  return  ordermapProduct.get(orderid).add(product)+" product Updated.";
		             }
		             else{
		            	throw new OrderManagementException("Sorry, Order id Not Available", LocalDateTime.now());
		             }
	}

}
