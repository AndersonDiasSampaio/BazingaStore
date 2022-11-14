package main;

import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Sku;
import br.com.bazingaStore.modelEnum.Type;
import br.com.bazingaStore.service.StockService;
import br.com.bazingaStore.modelEnum.*;
public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	StockService Stock = new StockService();
	Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black , Type.Dress, Size.XL, Category.Male, Sku.skua);
	System.out.println(Stock.listProduct());
	Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black , Type.Dress, Size.XL, Category.Male, Sku.skua);
	System.out.println(Stock.listProduct());
	Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black , Type.Dress, Size.XL, Category.Male, Sku.Skub);
	System.out.println(Stock.listProduct());
	Stock.deleteProduct(0);
	System.out.println(Stock.listProduct());

		
	}

}
