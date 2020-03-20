package ecommerce.dto;

import javax.servlet.http.Part;

public class Product {

	private Integer id;
	private String name;
	private Float price;
	private Integer quantity;
	private String description;
	private Part productImage;

	public Product(Integer id, String name, Float price, Integer quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Part getProductImage() {
		return productImage;
	}

	public void setProductImage(Part productImage) {
		this.productImage = productImage;
	}

}
