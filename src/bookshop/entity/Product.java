/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshop.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author pc asus
 */
@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
    private int id;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "Seller")
    private String seller;
	
	@Column(name = "Category")
    private String category;
	
	@Column(name = "Price")
    private double price;
	
	@Column(name = "Description")
    private String description;
	
	@Column(name = "Image")
    private String image;
		
    public Product() {
    }

	public Product(String name, String seller, String category, double price, String description, String image) {
		super();
		this.name = name;
		this.seller = seller;
		this.category = category;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public Product(int id, String name, String seller, String category, double price, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.seller = seller;
		this.category = category;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", seller=" + seller + ", category=" + category + ", price="
				+ price + ", description=" + description + ", image=" + image + "]";
	}
    
    
	
    
}
