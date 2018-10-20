package com.kiti.backend;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resources;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer producId;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private Currency currency;
	@ManyToMany(mappedBy = "products")
	private List<Category> categories = new ArrayList<Category>();
	
	@ElementCollection
	private List<String> images = new ArrayList<String>();
	
	private String indexImage;
	
	public String getIndexImage() {
		return indexImage;
	}
	
	public List<String> getImages(){
		return images;
	}
	
	//must have file type at the end. e.g index.png
	public void addImage(String image) {
		images.add(image);
		if (image.contains("index")) {
			indexImage = image;
		}
	}
	
	public Integer getProductId() {
		return producId;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setProductId(Integer producId) {
		this.producId = producId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Product(String name, Integer price, Currency currency) {
		super();
		this.name = name;
		this.price = price;
		this.currency = currency;
	}

	public Product() {
		
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) return false;
		return ((Product)o).name == this.name;
	}
	
	@Override
	public String toString() {
		String ret;
		ret = "Product basic summary: \n";
		ret += "\tID: " + producId + "\n";
		ret += "\tName: " + name + "\n";
		ret += "\tPrice: " + price + " " + currency + "\n";
		return ret;
	}
	
	public void addCategory(Category category) {
		category.addProduct(this); //the parent will automatically add itself to the current category list
	}
	
	public void removeCategory(Category category) {
		category.removeProduct(this); //the parent will automatically add itself to the current category list
	}
	
	/*
	public ProductInfoBasic(ResourceLoader loader, String folderLocation) throws IOException {
		this.folderLocation = folderLocation;
		BufferedReader reader = new BufferedReader(new InputStreamReader(loader.getResource(folderLocation + "/info.txt").getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("name:")) {
				name = line.split(":", 2)[1];
			}
			if (line.contains("price:")) {
				price = line.split(":", 2)[1];
			}
		}
		
		//now find all images in the folder
		allImages = new ArrayList<String>();
		Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(loader).getResources(folderLocation + "/*");
		for (int i = 0; i < resources.length; i++) {
			for (int j = 0; j < supportedImageFormat.length; i++) {
				if (resources[i].getDescription().contains(supportedImageFormat[j])) {
					allImages.add(resources[i].getDescription());
				}
				if (resources[i].getDescription().contains("index." + supportedImageFormat[j])){
					indexImage = resources[i].getDescription();
				}
			}
		}
	}
	*/
}
