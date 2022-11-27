package br.com.bazingaStore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sell {
	private List<Product> productList = new ArrayList<>();

	private Double price;
	private String CPF;
	private String dateTime;
	private PaymentMethod paymentMethod;
	public Sell() {
		this.price=0d;
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getDateTime() {
		return dateTime;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setDateTime() {
		LocalDateTime dateTime2 = LocalDateTime.now();
		String a= dateTime2.toString();
		dateTime = a.substring(0, 10);
	}

	@Override
	public String toString() {
		return "Histórico de Vendas [ Produtos:" + productList + ", price=" + price + ", CPF=" + CPF + ", dateTime=" + dateTime
				+ "]";
	}



}
