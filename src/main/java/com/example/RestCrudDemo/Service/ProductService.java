package com.example.RestCrudDemo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.RestCrudDemo.Exception.InvalidProductIDException;
import com.example.RestCrudDemo.Model.Product;

@Service
public class ProductService {
	
	private static ProductService instance;
	private static List<Product> data=new ArrayList();
	
	static {
		data.add(new Product(1,"I phone x",999.90f));
		data.add(new Product(2,"XBOX 360",330.50f));
		
	}
	
	public ProductService() {
		
	}
	
	public List<Product> listAll(){
		
		return new ArrayList<Product>(data);
	}
	
//	public boolean add(Product product) {
//		
//	}
	
	public Product get(int id) throws InvalidProductIDException{
		
		boolean flag = false;
		
		for(Product p1:data) {
			if (p1.getId()==id) {
				flag=true;
				return p1;
			}
		}
		
//		if(flag==false) {
//			
//			throw new InvalidProductIDException("Product ID doesn't exist");
//			
//		}
		return null;
	}
	
	public boolean add(Product product) {
		data.add(product);
		return true;
	}
	
	public boolean update(int productid) {
	boolean flag=false;
	for (Product l:data) {
		if(l.getId()==productid) {
			l.setName("Teja");
			flag=true;
		}
	}
	return flag;
}
	
	public boolean update(int productid,String n) {
	boolean flag=false;
	for (Product l:data) {
		if(l.getId()==productid) {
			l.setName(n);
			flag=true;
		}
	}
	return flag;
}
	public boolean delete(int id) {
		List<Product> list=new ArrayList();
		boolean flag=false;
		for (Product l:data) {
			if (l.getId()==id) {
				list.add(l);
			}
		}
		flag=data.removeAll(list);
		System.out.println(flag);
		return flag;
	}
}
