package br.com.bazingStore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingaStore.model.PaymentMethod;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;

public class SellData implements DataInterface {
	private List<Object> sellData = new ArrayList();
	private Sell sell = new Sell();

	public SellData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean delete(Object obj) {
		// SellData.remove((int) obj);
		return false;
	}

	@Override
	public void update(Object obj) {
		boolean b = false;
		Product pr = (Product) obj;
		for (Object element : sell.getProductList()) {
			Product product = (Product) element;
			System.out.println(product.getSku());
			if (pr.getSku() == product.getSku()) {
				product.setCategory(pr.getCategory());
				product.setColor(pr.getColor());
				product.setDepartment(pr.getDepartment());
				product.setDescription(pr.getDescription());
				product.setPrice(pr.getPrice());
				product.setQuantity(pr.getQuantity() + product.getQuantity());
				product.setSize(pr.getSize());
				product.setType(pr.getType());
				b = true;
			}
		}
		if (b == false) {
			save(obj);
		}
	}

	@Override
	public List<Object> listItens() {
		return sellData;
	}

	@Override
	public Object getItem(Object obj) {

		return this.sell.getProductInTheList((int) obj);
		// this.sell.getProductList().get((int) obj);
	}

	@Override
	public void save(Object obj) {
		Product product = (Product) obj;
		// TODO Auto-generated method stub
		this.sell.setProduct(product);

	}

	public void refrestcard() {
		this.sell = new Sell();
	}

	public void save(double b) {
		
		this.sell.setDateTime();
		this.sell.setPrice(b);

		sellData.add(sell);

	}

	public void save(double price, String CPF, String PaymentMethod, String valueBancaryData ) {
		this.sell.setPaymentMethod(PaymentMethod, valueBancaryData);
		this.sell.setDateTime();
		this.sell.setCPF(CPF);
		this.sell.setPrice(price);

		sellData.add(sell);

	}
	
	public void setSellCPF(String a) {
		this.sell.setCPF(a);
	}

	/*public void setPayment(PaymentMethod a) {
		this.sell.setPaymentMethod(a);

	}*/
	public List<Product> listProduct() {

		return this.sell.getProductList();
	}
}
