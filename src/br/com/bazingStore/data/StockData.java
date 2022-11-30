package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.Product;

public class StockData implements DataInterface {
	private List<Object> productList= new ArrayList<>();

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
		boolean b= false;
		Product pr= (Product) p;
		for (Object element : productList) {
			Product product = (Product) element;
			if(pr.getSku()==product.getSku()) {
				product.setCategory(pr.getCategory());
				product.setColor(pr.getColor());
				product.setDepartment(pr.getDepartment());
				product.setDescription(pr.getDescription());
				product.setPrice(pr.getPrice());
				product.setQuantity(  pr.getQuantity());
				product.setSize(pr.getSize());
				product.setType(pr.getType());
				b=true;
			}
		}if(b==false) {
			save(p);
		}

	}

	@Override
	public void save(Object Product) {

		// TODO Auto-generated method stub
	this.productList.add(Product);

	}


	@Override
	public List<Object> listItens() {
		// TODO Auto-generated method stub
		return this.productList;	}

	@Override
	public Object getItem(Object obj) {
		
		// TODO Auto-generated method stub
		return productList.get((int)obj);
	}


//Ver porque acho que deve ir pra o Service
	/*public void setProductList(List<Object> productList) {

		for (Object element : productList) {
			System.out.println((Product)element);
			update(element);
		}
	}*/

}
