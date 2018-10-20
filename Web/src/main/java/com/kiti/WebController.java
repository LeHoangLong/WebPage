package com.kiti;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiti.backend.*;

@Controller
public class WebController {
	
	public WebController() {
	}
	@PostConstruct
	public void initializeDatabase() {
		//initialize database
		Category cat0 = new Category("test0");
		Category cat1 = new Category("test1");
		Product product0 = new Product("product 0", 100, Currency.VND);
		Product product1 = new Product("product 1", 200, Currency.VND);
		Product product2 = new Product("product 2", 300, Currency.VND);
		Product product3 = new Product("product 3", 400, Currency.VND);
		
		product0.addImage("index.jpg");
		product0.addImage("image1.jpg");
		product0.addImage("image2.jpg");
		product0.addImage("image3.jpeg");
		product1.addImage("index.jpeg");
		product2.addImage("index.jpeg");
		product3.addImage("index.jpeg");
		
		cat0 = categoryRepository.save(cat0);
		cat1 = categoryRepository.save(cat1);
		productRepository.save(product0);
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		cat0.addProduct(product0);
		cat0.addProduct(product1);
		cat0.addProduct(product2);
		cat0.addProduct(product3);
		cat1.addProduct(product1);
		cat1.addProduct(product2);
		categoryRepository.save(cat0);
		categoryRepository.save(cat1);

		Account user0 = new Account();
		user0.setPassword("123");
		user0.setUsername("123");
		user0.setRealName("Long");
		user0 = accountRepository.save(user0);
}
	
	@Autowired
	ServletContext context;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	int depth = 3;
	
	@RequestMapping("welcome")
	public String welcome() {
		return "result";
	}
	
	@RequestMapping("/")
	public String mainPage(@CookieValue(), Model model) {
		//check if first visit
		model.addAttribute("AccountName", "Account");
		List<Category> categories = categoryRepository.findAll(); //actually, we should use a seperate thread, otherwise it would consume a lot of computation everytime the main page is loaded

		model.addAttribute("categories", categories);
		//System.out.println("root path: " + context.getRealPath("/"));
		
		return "mainPage";
	}
	
	@RequestMapping(value="category")
	public String categoryPage(@RequestParam(value = "category", required=true) String category, Model model) {
		model.addAttribute("AccountName", "Account");
		try {
			List<Product> products = categoryRepository.findById(new Integer(category)).get().getProducts();
			model.addAttribute("products", products);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		/*
		try {
			CategoryFileReader categoryFile = new CategoryFileReader("resources/Category" + category);
			List<String> productNames = categoryFile.getCategories();
			for (ListIterator<String> i = productNames.listIterator(); i.hasNext();) {
				String productName = i.next();
				i.set("resources/database/Products/" + productName);
			}
			model.addAttribute("products", productNames);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		*/
		return "categoryDisplay";
	}
	
	@RequestMapping("/product")
	public String productPage(@RequestParam(value="productId", required=true) String productId, Model model) {
		Product product = productRepository.findById(new Integer(productId)).get(); //should handle exception here
		model.addAttribute("product", product);
		return "productDisplay";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/loginSubmitted")
	public String loginSubmitted(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password, HttpServletResponse response) {
		Optional<Account> account;
		try {
			if (((account = accountRepository.findById(username)) != null) && account.get().getPassword().equals(password)) {
				System.out.println("success");
				response.addCookie(new Cookie("sessionId", "123"));
			}else {
				System.out.println("failed");
			}
		} catch(Exception e) {
			System.out.println("failed");
		}
		return "login";
	}
}
