package com.example.RestCrudDemo.Controller;

import java.io.InvalidClassException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestCrudDemo.Exception.InvalidProductIDException;
import com.example.RestCrudDemo.Model.Product;
import com.example.RestCrudDemo.Service.ProductService;


//C-Created,R-Read,U-Update,D-Delete (CRUD)


@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/listall")
	public List<Product> list(){
		return service.listAll();
	}

	
//	@GetMapping("test")
//	public String getParamRequest(@RequestParam int id,@Requestparam String name) {
//		
//		return "Your id is "|id|" your name is "|name;
//	}
//	
//	public String getParamRequest() {
//		retrun "Your name is" +name
//	}
	
	@RequestMapping(value="/getproduct/{id}",method=RequestMethod.GET)
	public Product get(@PathVariable("id") int i) {
		System.out.println(i);
		Product product=null;
		
		try {
			product=service.get(i);
		}
		catch (InvalidProductIDException e) {
			System.out.println(e);
		}
		
		return product;
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public Product add(@RequestBody Product product) {
		
		service.add(product);
		System.out.println(product);
		return product;
	}
	
	@PutMapping("/updateproduct/{id}/{name}")
	public boolean update(@PathVariable("id") int id,@PathVariable("name")String name) {
		
		if (service.update(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	@PutMapping("/updateproduct/{id}")
	public boolean update(@PathVariable("id") int id) {
		
		if (service.update(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public boolean delete(@PathVariable("id") int id) {
		
		if (service.delete(id)) {
			return true;
		}else {
			return false;
		}
	}
}
