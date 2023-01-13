package com.revature.kbms.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ProductTreeSort {
	public static void main(String[] args) {
		
		Product coffee = new Product(1001, "Nescafe",40, 30, "20-10-2023" , 100.00);
		Product cookies = new Product(1002, "Goodday",50, 20, "20-10-2023" , 100.00);
		
		List<Product> product = new ArrayList<Product>();
		product.add(coffee);
		product.add(cookies);
		
		for(Product p: product) {
			System.out.println(p.getProductId()+" "+ p.getProductName()+" "+ p.getProductCount()+" "+ p.getTotalStock()+" "+ p.getPricePerUnit()+" "+ p.getBestBefore()  );
			
		}
		Collections.sort(product, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getProductName().compareTo( p2.getProductName());
				
			}
		});
		
		for(Product p: product) {
			System.out.println(p.getProductId()+" "+ p.getProductName()+" "+ p.getProductCount()+" "+ p.getTotalStock()+" "+ p.getPricePerUnit()+" "+ p.getBestBefore()  );
			
		}

}
}
