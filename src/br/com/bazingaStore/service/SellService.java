package br.com.bazingaStore.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bazingStore.data.SellData;
import br.com.bazingStore.data.StockData;
import br.com.bazingaStore.model.Cash;
import br.com.bazingaStore.model.CredCard;
import br.com.bazingaStore.model.Debit;
import br.com.bazingaStore.model.Pix;
import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;

public class SellService {
//mudar nome de variaveis auxiliares
	private SellData sellData = new SellData();

	public SellService() {
		// TODO Auto-generated constructor stub
	}

	public String addProductCard(Product product, int quantity) {
		Product p = new Product();
		p = product;

		if (p.getSku() == 0) {
			return "Nao foi possivel adicionar ao carrinho de compras";
		} else {

			
			p.setQuantity(quantity);
			Object p2 = p;
			sellData.update(p2);

			return "Adicionado com sucesso ao carrinho de compras: " + "\n" + p2.toString();
		}
	}

	public List<Product> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}
	public List<Object>  getSellDataList() {
		return sellData.listItens();
	}
	

	public void cancel() {
		sellData.refrestcard();

	}

	public void setAndVerifyCPF(String a) {
		this.sellData.setSellCPF(a);
	}

	public String sellStockTestAndBuy(StockService Stock, CashRegisterService cash, String CPF, String PaymentMethod, String valueBancaryData) {
		double priceToBil = 0d;
		Object obj;
		int negativeCount = productIncardToSell().size();
		if(sellData.listProduct().size()>0) {
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
							priceToBil = (p8.getPrice() * p8.getQuantity()) + priceToBil;

						}

					}

				}

				sellData.save(priceToBil,CPF, PaymentMethod,valueBancaryData );



				return "Pedido realizado com sucesso";
			} else {
				sellData.refrestcard();
				return "Pedido cancelado, produtos do carrinho exedem a quantidade do estoque";
			}
		}else {
			return "Pedido cancelado, carinho vazio";
		}
		

	}

}
