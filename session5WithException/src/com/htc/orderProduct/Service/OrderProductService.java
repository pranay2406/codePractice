package com.htc.orderProduct.Service;

import java.util.List;
import com.htc.orderProduct.entity.OrderProduct;
import com.htc.orderProduct.entity.Product;

public interface OrderProductService {
	    public String addOrder(OrderProduct orderproduct);
	    public List<Product> findAllProductByOrderId(String orderId);
	    public String deleteOrderedProduct(String orderid,Product product) ;
	    public String updateProductQuantity(String orderid, Product product);

}
