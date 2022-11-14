package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.Product;

public class StockData implements DataInterface {
	List<Object> productList= new ArrayList<>();

	public StockData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean delete(Object obj) {
		
		this.productList.remove((int)obj);
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public void update(Object p) {
		Product pr= (Product) p;
		for(int x=0; x<productList.size();x++) {
			Product product = (Product) productList.get(x);
			if(pr.getSku()==product.getSku()) {
				product.setCategory(pr.getCategory());
				product.setColor(pr.getColor());
				product.setDepartment(pr.getDepartment());
				product.setDescription(pr.getDescription());
				product.setPrice(pr.getPrice());
				product.setQuantity(pr.getQuantity());
				product.setSize(pr.getSize());
				product.setType(pr.getType());
			}
		}
		
	}

	@Override
	public void save(Object Product) {
		
		// TODO Auto-generated method stub
	this.productList.add((Product)Product);

	}
	

	@Override
	public List<Object> listItens() {
		// TODO Auto-generated method stub
		return this.productList;	}

	@Override
	public Object getItem(Object obj) {
		// TODO Auto-generated method stub
		return null;
	} 

}
