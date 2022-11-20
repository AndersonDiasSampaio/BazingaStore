package br.com.bazingaStore.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingStore.data.SellData;
import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Product;

public class SellService {
//mudar nome de variaveis auxiliares
	SellData sellData = new SellData();

	public SellService() {
		// TODO Auto-generated constructor stub
	}

	public String addProductCard(Product product, int quantity) {
		Product p = new Product();
		p = product;
		p.setQuantity(quantity);
		sellData.addSellProduc(p);

		return "Adicionado com sucesso ao carrinho de compras: " + "\n" + product.toString();
	}

	public List<Product> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}
// falta fazer um método para quando cancelar a compra
	public String sellStockTestAndBuy(StockService Stock) {
		int negativeCount = productIncardToSell().size();
		for (int x = 0; x < Stock.getDataStock().size(); x++) {
			// System.out.println(Stock.getProduct(x));
			for (int y = 0; y < productIncardToSell().size(); y++) {
				Product p8 = (Product) getSellData().getItem(y);
				if (p8.getSku() == Stock.getProduct(x).getSku()
						&& p8.getQuantity() <= Stock.getProduct(x).getQuantity()) {
					negativeCount--;

				}

			}

		}
		if (negativeCount == 0) {
			for (int x = 0; x < Stock.getDataStock().size(); x++) {
				for (int y = 0; y < productIncardToSell().size(); y++) {
					Product p8 = (Product) getSellData().getItem(y);
					if (p8.getSku() == Stock.getProduct(x).getSku()) {
						Stock.getProduct(x).setQuantity(Stock.getProduct(x).getQuantity() - p8.getQuantity());

					}

				}

			}
			sellData.save();

			return "Pedido realizado com sucesso";
		} else {
			return "Pedido cancelado, produtos do carrinho exedem a quantidade do estoque";
		}

	}

	/*
	 * public String testEstoque() { for (int y = 0; y <
	 * sellData.listProduct().size(); y++) { System.out.println("passou"); for (int
	 * x = 0; x < stockTest.listItens().size(); x++) {
	 * System.out.println("Produto 2" + stockTest.getItem(x)); Product product2 =
	 * (Product) stockTest.getItem(x); System.out.println("passou");
	 * System.out.println("Produto 1" + stockTest.getItem(x));
	 * 
	 * Product product1 = (Product) sellData.getItem(y);
	 * System.out.println("Produto 1" + stockTest.getItem(x)); if (product1.getSku()
	 * == product2.getSku()) { System.out.println( product2.getQuantity() -
	 * product1.getQuantity());
	 * 
	 * if (product2.getQuantity() >= product1.getQuantity()) {
	 * product2.setQuantity(product2.getQuantity() - product1.getQuantity());
	 * System.out.println( product2.getQuantity() - product1.getQuantity());
	 * stockTest.update(product2); } else {
	 * this.stockTest.setProductList(this.stock.listItens()); return
	 * "Compra cancelada o produto: " + product1.getDescription() +
	 * " nao possui quantidade suficiente no estoque " +
	 * "a quantidade suficente é: " + product2.getQuantity(); }
	 * 
	 * } } } this.stock.setProductList(this.stockTest.listItens());
	 * 
	 * return "Compra realizada com sucesso"; }
	 * 
	 * public StockData getStock() { return stock; }
	 */
	/*
	 * public void setStock(List<Object> stock) { this.stock.setProductList(stock);
	 * this.stockTest.setProductList(stock);
	 * 
	 * }
	 */

}
