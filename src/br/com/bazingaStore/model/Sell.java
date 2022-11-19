package br.com.bazingaStore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sell {
	private List<Product> productList = new ArrayList<>();

	private Double price;
	private Integer CPF;
	private LocalDateTime dateTime;

	public Sell() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProductList() {
		return productList;
	}
	public Product getProductInTheList(int x) {
		return productList.get(x);
	}
	public void setProduct(Product product) {
		this.productList.add(product);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCPF() {
		return CPF;
	}

	public void setCPF(Integer cPF) {
		CPF = cPF;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Sell [productList=" + productList + ", price=" + price + ", CPF=" + CPF + ", dateTime=" + dateTime
				+ "]";
	}



}
