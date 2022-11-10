package br.com.bazingaStore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sell {
	private List<Product> productList = new ArrayList<Product>();

	private Double price;
	private Integer CPF;
	private LocalDateTime dateTime;

	public Sell() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProduct(Product productList) {
		this.productList.add(productList);
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

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
