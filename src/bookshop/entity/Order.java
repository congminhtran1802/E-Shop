/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshop.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author pc asus
 */

@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
    private int id;
	
	@Column(name = "Buyer")
    private String buyer;
	
	@Column(name = "Seller")
    private String seller;
	
	@Column(name = "ProductId")
    private int productId;
	
	@Column(name = "Quantity")
    private int quantity;
	
	@Column(name = "OrderDate")
    private LocalDate orderDate;
	
	@Column(name = "ShippingAddress")
    private String shippingAddress;
	
	@Column(name = "TotalAmount")
    private double totalAmount;
	
	@Column(name = "Status")
	private boolean status;

    public Order() {
    }

	public Order(String buyer, String seller, int productId, int quantity, LocalDate orderDate, String shippingAddress,
			double totalAmount, boolean status) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public Order(int id, String buyer, String seller, int productId, int quantity, LocalDate orderDate,
			String shippingAddress, double totalAmount, boolean status) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.seller = seller;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", buyer=" + buyer + ", seller=" + seller + ", productId=" + productId
				+ ", quantity=" + quantity + ", orderDate=" + orderDate + ", shippingAddress=" + shippingAddress
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}

	

    
    
}
