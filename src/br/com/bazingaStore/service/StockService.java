package br.com.bazingaStore.service;

import java.util.List;

import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Type;

public class StockService {
	StockData DataStock = new StockData();

	public StockService() {
		// TODO Auto-generated constructor stub
	}

	public String registProduct(Integer quantity, Double price, String department, String description, Color color,
			Type type, Size Size, Category category, int Sku) {
		Product product = new Product(quantity, price, department, description,
				Sku /* , color, type, Size, category, */);
		List<Object> Stock = DataStock.listItens();
		boolean isNew = true;
		for (Object element : Stock) {
			Product product2 = (Product) element;
			if (product.getSku() == product2.getSku()) {
				product2.setCategory(product.getCategory());
				product2.setColor(product.getColor());
				product2.setDepartment(product.getDepartment());
				product2.setDescription(product.getDescription());
				product2.setPrice(product.getPrice());
				product2.setQuantity(product.getQuantity() + product2.getQuantity());
				product2.setSize(product.getSize());
				product2.setType(product.getType());
				DataStock.update(product2);
				isNew = false;
			}

		}
		if (isNew) {
			DataStock.save(product);
		}
		return "Produto cadastrado com sucesso!";

	}
	public String registProduct(Integer quantity, Double price, String description, int Sku) {
		Product product = new Product(quantity, price, description, Sku);
		List<Object> Stock = DataStock.listItens();
		boolean isNew = true;
		for (Object element : Stock) {
			Product product2 = (Product) element;
			if (product.getSku() == product2.getSku()) {
				product2.setCategory(product.getCategory());
				product2.setColor(product.getColor());
				product2.setDepartment(product.getDepartment());
				product2.setDescription(product.getDescription());
				product2.setPrice(product.getPrice());
				product2.setQuantity(product.getQuantity() + product2.getQuantity());
				product2.setSize(product.getSize());
				product2.setType(product.getType());
				DataStock.update(product2);
				isNew = false;
			}

		}
		if (isNew) {
			DataStock.save(product);
		}
		return "Produto cadastrado com sucesso!";

	}
	public String listProduct() {
		String exit = "Lista de produtos" + "\n";
		List<Object> Stock = DataStock.listItens();
		for (Object element : Stock) {
			Product product = (Product) element;
			exit += product.toString();

		}

		return exit;
	}

	public String deleteProduct(int a) {
		List<Object> Stock = DataStock.listItens();

		for (int x = 0; x < Stock.size(); x++) {
			Product product2 = (Product) Stock.get(x);
			if (a == product2.getSku()) {
				DataStock.delete(x);

			}

		}

		return "Objeto deletado";
	}
	public Product getProduct(int a) {

		return (Product) DataStock.getItem(a);
	}
	public Product returnProductInStock(int a) {
		Product product= new Product();
		List<Object> Stock = DataStock.listItens();

		for (int x = 0; x < Stock.size(); x++) {
			Product product2 = (Product) Stock.get(x);
			if (a == product2.getSku()) {
				product.setCategory(product2.getCategory());
				product.setColor(product2.getColor());
				product.setDepartment(product2.getDepartment());
				product.setDescription(product2.getDescription());
				product.setPrice(product2.getPrice());
				product.setQuantity(product2.getQuantity());
				product.setSize(product2.getSize());
				product.setSku(a);
				product.setType(product2.getType());

			}

		}
		
		return product;
	}

	public List<Object> getDataStock() {
		return this.DataStock.listItens();
	}

	/*public void updateStockData(List<Object> list) {
		this.DataStock.setProductList(list);

	}*/

}
