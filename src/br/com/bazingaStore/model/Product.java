package br.com.bazingaStore.model;

import br.com.bazingaStore.modelEnum.*;

public class Product {

	private Integer quantity;
	private Double price;
	private String department;
	private String description;

	private Color color;
	private Type type;
	private Size Size;
	private Category category;
	private Sku Sku;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Sku getSku() {
		return Sku;
	}

	public void setSku(Sku sku) {
		Sku = sku;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return Size;
	}

	public void setSize(Size size) {
		Size = size;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
