package com.ecom.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CartId;
	
	@ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "customer_id" , referencedColumnName = "id") private
	 * Customer customer;
	 */
//	private Long productId;
	private Integer quantity;
	
	@OneToMany
	private List<Product> products = new ArrayList<>();

	public Cart() {
		super();
		
	}

	Cart(Long cartId, Product product, Integer quantity, List<Product> products) {
		super();
		CartId = cartId;
		this.product = product;
		this.quantity = quantity;
		this.products = products;
	}

	public Long getCartId() {
		return CartId;
	}

	public void setCartId(Long cartId) {
		CartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", product=" + product + ", quantity=" + quantity + ", products=" + products
				+ "]";
	}

	
		
}
