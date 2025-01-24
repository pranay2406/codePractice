package com.htc.orderProduct.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.htc.orderProduct.Service.OrderProductService;
import com.htc.orderProduct.ServiceIMPL.OrderProductServiceImpl;
import com.htc.orderProduct.daoIMPL.orderProductDaoImpl;
import com.htc.orderProduct.entity.OrderProduct;
import com.htc.orderProduct.entity.Product;

public class OrderProductApp {

	public static void main(String[] args) {
		   
		String choice;
		char repeat = 'n';
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("P001","Moniter",100,15000.0f,LocalDate.of(2025, 01, 24),LocalDate.of(2030, 12, 01)));
		products.add(new Product("P002","Lays",50,15.0f,LocalDate.of(2025, 01, 24),LocalDate.of(2026, 12, 01)));
		products.add(new Product("P003","Maggie",70,22.0f,LocalDate.of(2024, 1, 24),LocalDate.of(2027, 12, 01)));
		
		OrderProduct orderproduct = new OrderProduct("OR001", products);
		
		OrderProductService orderproductservice = new OrderProductServiceImpl();
        do {
                                    System.out.println("Enter your choice:");
                                    System.out.println("1. Add order");
                                    System.out.println("2. Update the product quantity");
                                    System.out.println("3. Delete a product");
                                    System.out.println("4. Reterive all product");
                                    System.out.println("5. Exit");
                                    Scanner input = new Scanner(System.in);
                                    choice = input.next();

                                    switch(choice) {
                                                case "add":
                                                            System.out.println(orderproductservice.addOrder(orderproduct));;
                                                            break;
                                                case "update":
                                                            String orderid,productid;
                                                            int quantity;
                                                            Product product;
                                                            System.out.println("Enter the orderid to update quantity:");
                                                            orderid = input.next().toUpperCase();
                                                            System.out.println("Enter the productid and quantity");
                                                            productid=input.next().toUpperCase();
                                                            quantity = input.nextInt();
                                                            product = new Product(productid.toUpperCase(),"",quantity,0.0f,null,null);
                                                       System.out.println(orderproductservice.updateProductQuantity(orderid, product));;
                                                            break;
                                                            
                                                case "delete":
                                                            String deleteorderid,dproductid;
                                                            Product deleteproduct;
                                                            System.out.println("Enter the orderid to search:");
                                                            deleteorderid = input.next().toUpperCase();
                                                            System.out.println("Enter the product id to be deleted:");
                                                            dproductid = input.next().toUpperCase();
                                                            deleteproduct = new Product(dproductid,"",0,0.0f,null,null);
                                                       System.out.println(orderproductservice.deleteOrderedProduct(deleteorderid, deleteproduct));
                                                            break;

                                                case "reterive":
                                                            String sorderid;
                                                            System.out.println("Enter the orderid:");
                                                            sorderid = input.next();
                                                            orderproductservice.findAllProductByOrderId(sorderid)
                                                                                                .stream()
                                                                                                .forEach(prod -> System.out.println(prod));
                                                            break;

                                                case "exit":
                                                            System.out.println("Thank you! Visit again");
                                                            System.exit(0);
                                                default:
                                                            System.out.println("Please select a valid choice");
                                    }
                                    System.out.println("Do you want to repeat? choose ''Y or 'N'");
                                    repeat = input.next().charAt(0);
                        }while(repeat=='y');
                        System.out.println("Thank you!");
	}
}
