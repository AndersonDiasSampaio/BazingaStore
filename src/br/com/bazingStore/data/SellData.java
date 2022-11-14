package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;

public class SellData implements DataInterface {
	List<Object> SellData = new ArrayList();
	Sell sell = new Sell();
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

	@Override
	public void save(Object obj) {
		Sell sell1 = new Sell();
		sell1 = (Sell) obj;
		SellData.add(sell);
		this.sell= null;
	}

	@Override
	public List<Object> listItens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItem(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addSellProduc(Product product) {
		this.sell.setProduct(product);
	}
	


}
