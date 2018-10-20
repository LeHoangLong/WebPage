package com.kiti.backend;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "Category_Product", joinColumns = @JoinColumn(name = "categoryId"), inverseJoinColumns = @JoinColumn(name = "producId"))
	private List<Product> products = new ArrayList<Product>();

	public Integer getCategoryId() {
		return categoryId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		product.getCategories().add(this);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		product.getCategories().remove(this);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) return false;
		return ((Category)o).name == this.name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {
		
	}
	
}
