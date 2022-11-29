package br.com.bazingaStore.comunication;

import java.util.Scanner;

import br.com.bazingaStore.service.CashRegisterService;
import br.com.bazingaStore.service.ProductService;
import br.com.bazingaStore.service.SellService;
import br.com.bazingaStore.service.StockService;

public class TestClass {

	public TestClass() {
		// TODO Auto-generated constructor stub
	}
public void teste(CashRegisterService cash, SellService Sell, StockService Stock) {
	Scanner entry = new Scanner(System.in);
	String description;
	int quantity;
	Double price;
	int sku;

	int value = 0;
	boolean y = true;
	while (y == true) {
		System.out.println("Digite 1 para listar Roupas");
		System.out.println("Digite 2  selecionar Roupas");
		System.out.println("Digite 3 para Finalizar a compra");
		System.out.println("Digite 4 para cancelar a compra");
		System.out.println("Digite 5 para voltar ao menu anterior");

		value = entry.nextInt();
		if (value == 1) {
			System.out.println(Stock.listProduct());
		} else if (value == 2) {
			System.out.println("Digite o SKU do produto");
			sku = entry.nextInt();
			System.out.println("Digite a quantidade do produto");
			quantity = entry.nextInt();
			Sell.addProductCard(Stock.returnProductInStock(sku), quantity);
			System.out.println(Sell.productIncardToSell());

		} else if (value == 3) {
			String text;
			System.out.println("Deseja Salvar o CPF? ");
			System.out.println("Digite 1 para Sim");
			System.out.println("Digite 2 para nao");
			value = entry.nextInt();

			if (value == 1) {
				System.out.println("Digiteo valor do CPF");
				text = entry.next();
				Sell.setAndVerifyCPF(text);
			} else if (value == 2) {

			} else {
				System.out.println("Valor invalido");
			}

			System.out.println(Sell.sellStockTestAndBuy(Stock, cash));
		} else if (value == 4) {
		}
		if (value == 5) {
			y = false;
			System.out.println("Retornando ao menu anterior");

		} else {
			System.out.println("Digite o valor correto");

		}
	}


}
}
