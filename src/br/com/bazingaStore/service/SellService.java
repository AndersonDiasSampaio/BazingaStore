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
		Object p2 = p;
		sellData.save(p2);

		return "Adicionado com sucesso ao carrinho de compras: " + "\n" + product.toString();
	}

	public List<Product> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}

	public void setPaymentMethod(String a, int b) {

	}

	public void setAndVerifyCPF(String a) {
	this.sellData.setSellCPF(a);
	}

// falta fazer um método para quando cancelar a compra
	public String sellStockTestAndBuy(StockService Stock) {
		double priceToBil=0d;
		int negativeCount = productIncardToSell().size();
		for (int x = 0; x < Stock.getDataStock().size(); x++) {
			// System.out.println("TEste +++" +Stock.getDataStock());
			for (int y = 0; y < productIncardToSell().size(); y++) {
				Product p8 = (Product) getSellData().getItem(y);
				// System.out.println("TEste +++" +p8);

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
						priceToBil= (p8.getPrice()*p8.getQuantity())+priceToBil;

					}

				}

			}
			sellData.save(priceToBil);
			System.out.println(sellData.listItens());


			return "Pedido realizado com sucesso";
		} else {
			return "Pedido cancelado, produtos do carrinho exedem a quantidade do estoque";
		}

	}

}
