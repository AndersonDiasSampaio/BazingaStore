package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;

public class SellData implements DataInterface {
	private List<Object> SellData = new ArrayList();
	private Sell sell = new Sell();

	@Override
	public String toString() {
		return "SellData [SellData=" + SellData + ", sell=" + sell + "]";
	}

	public SellData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean delete(Object obj) {
		SellData.remove((int) obj);
		return false;
	}

	@Override
	public void update(Object obj) {

	}

	
	public void save(double b) {
		
		this.sell.setDateTime();
		this.sell.setPrice(b);
		
		SellData.add(sell);
		
		this.sell = new Sell();
	}

	@Override
	public List<Object> listItens() {
		return SellData;
	}

	@Override
	public Object getItem(Object obj) {


		return this.sell.getProductInTheList((int)obj);
				//this.sell.getProductList().get((int) obj);
	}

/*	public void addSellProduc(Product product) {
		this.sell.setProduct(product);
	}*/

	public List<Product> listProduct() {

		return this.sell.getProductList();
	}

	@Override
	public void save(Object obj) {
		Product product =  (Product) obj;
		// TODO Auto-generated method stub
		this.sell.setProduct(product);
		
	}
	public void setSellCPF(String a) {
		this.sell.setCPF(a);
	}

}
