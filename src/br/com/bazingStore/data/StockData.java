package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.Product;

public class StockData implements DataInterface {
	List<Product> productList= new ArrayList<Product>();

	public StockData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Product Product) {
		// TODO Auto-generated method stub
		this.productList.remove(Product);

	}

	@Override
	public void update(Product Product) {
		
	}

	@Override
	public void save(Product Product) {
		// TODO Auto-generated method stub
	this.productList.add(Product);

	}
	public List<Product> stockList(){
		return this.productList;
	} 

}
