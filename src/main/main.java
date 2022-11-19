package main;

import java.util.List;

import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.comunication.ProductComunication;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Type;
import br.com.bazingaStore.service.SellService;
import br.com.bazingaStore.service.StockService;
import br.com.bazingaStore.modelEnum.*;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SellService Sell = new SellService();
		StockService Stock = new StockService();
		StockService Stock2 = new StockService();

		// ProductComunication Comunication = new ProductComunication();
		Product p = new Product(20, 20d, 4);
		Product p2 = new Product(20, 20d, 5);
		Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black, Type.Dress, Size.XL, Category.Male, 4);
		Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black, Type.Dress, Size.XL, Category.Male, 5);
		Stock.registProduct(20, 20d, "Roupa", "Calsa", Color.black, Type.Dress, Size.XL, Category.Male, 6);
		System.out.println(Stock.listProduct());
		// Stock2.updateStockData(Stock.getDataStock());

		// Sell.setStock(Stock.getDataStock());

		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(Sell.addProductCard(p, 5));
		System.out.println(Sell.addProductCard(p2, 6));
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(Stock.listProduct());
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////");

		System.out.println(Sell.productIncardToSell());
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println(Stock.getDataStock());
		System.out.println("//////////////////////////////////////////////////////////////////////////////////////");

		// System.out.println(Sell.testEstoque());
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println(Stock.listProduct());

		

		System.out.println(Stock.listProduct());
		System.out.println(Sell.sellStockTest(Stock));
		System.out.println(Stock.listProduct());
		
		System.out.println(Sell.getSellData().listItens());



	}

}
