package br.com.bazingaStore.service;

import br.com.bazingStore.data.SellData;
import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Product;

public class SellService {
StockData stock= new StockData();
SellData sellData= new SellData();
	public SellService() {
		// TODO Auto-generated constructor stub
	}
	public String addProductCard(Product product) {
		sellData.addSellProduc(product);
		return product.toString() + " " + "adicionado com sucesso ao carrinho de compras";
	}
}
