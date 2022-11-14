package br.com.bazingaStore.service;

import java.util.List;

import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Sku;
import br.com.bazingaStore.modelEnum.Type;

public class StockService {
	StockData DataStock = new StockData();

	public StockService() {
		// TODO Auto-generated constructor stub
	}

	public String registProduct(Integer quantity, Double price, String department, String description, Color color,
			Type type, Size Size, Category category, Sku Sku) {
				Product product = new Product(quantity, price, department, description, color, type, Size, category, Sku);
				List<Object> Stock= DataStock.listItens();
				boolean isNew=true;
				for(int x=0; x<Stock.size();x++) {
					Product product2 = (Product) Stock.get(x);
					if(product.getSku()==product2.getSku()) {
						product2.setCategory(product.getCategory());
						product2.setColor(product.getColor());
						product2.setDepartment(product.getDepartment());
						product2.setDescription(product.getDescription());
						product2.setPrice(product.getPrice());
						product2.setQuantity(product.getQuantity()+product2.getQuantity());
						product2.setSize(product.getSize());
						product2.setType(product.getType());
						DataStock.update(product2);
						isNew=false;
					}
					
					
				}if(isNew==true) {
					DataStock.save(product);
				}	
		return "Produto cadastrado com sucesso!";

	}
	public String listProduct() {
		String exit= "Lista de produtos"+"\n";
		List<Object> Stock= DataStock.listItens();
		for(int x=0; x<Stock.size();x++) {
			Product product = (Product) Stock.get(x);
			exit+=product.toString();
			
		}
		
		return exit;
	}
	
	public String deleteProduct(int a) {
	DataStock.delete(a);
		return "Objeto deletado";
	}

}
