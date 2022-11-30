package br.com.bazingaStore.comunication;

import java.util.Scanner;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.service.CashRegisterService;
import br.com.bazingaStore.service.SellService;
import br.com.bazingaStore.service.StockService;

public class StoreComunication {
	String description;
	int quantity;
	Double price;
	int sku;

	public void paySystemLn() {
		System.out.println("Digite o metodo de pagamento");
		System.out.println("Cash");
		System.out.println("Debit");
		System.out.println("CredCard");
		System.out.println("Pix");
	}

	public StoreComunication() {
		boolean x = true;
		SellService Sell = new SellService();
		StockService Stock = new StockService();
		CashRegisterService cash = new CashRegisterService();

		Scanner entry = new Scanner(System.in);
		int value = 0;

		while (x == true) {
			System.out.println("Bem vindo ao Sistema de Gerenciamento e venda de Roupas Bazinga");
			System.out.println("1 - Para Adicionar Roupas ao estoque");
			System.out.println("2 - Para Verificar Stock ");
			System.out.println("3 - Para Venda de Roupas ");
			System.out.println("4 - para ver o caixa");
			System.out.println("5 - para sair");

			value = entry.nextInt();
			if (value == 1) {

				System.out.println("Digite a descricao do produto");
				this.description = entry.next();
				System.out.println("Digite a quantidade do produto");
				this.quantity = entry.nextInt();
				System.out.println("Digite o preco do produto");
				this.price = entry.nextDouble();
				System.out.println("Digiteo SKU");
				this.sku = entry.nextInt();
				System.out.println(Stock.registProduct(quantity, price, description, sku));

			} else if (value == 2) {
				System.out.println(Stock.listProduct());

			} else if (value == 3) {
				boolean y = true;
				while (y == true) {
					System.out.println("1 - para listar Roupas");
					System.out.println("2 - selecionar Roupas");
					System.out.println("3 - para Finalizar a compra");
					System.out.println("4 - para cancelar a compra");
					System.out.println("5 - para voltar ao menu anterior");

					value = entry.nextInt();
					if (value == 1) {
						System.out.println(Stock.listProduct());
					} else if (value == 2) {
						System.out.println("Digite o SKU do produto");
						this.sku = entry.nextInt();
						System.out.println("Digite a quantidade do produto");
						this.quantity = entry.nextInt();
						Sell.addProductCard(Stock.returnProductInStock(this.sku), this.quantity);
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
							paySystemLn();
							text = entry.next();
							System.out.println("Digite os dados do metodo de pagemento");
							String text2 = entry.next();
							text2=text2.toUpperCase();
							System.out.println(text2);

							Sell.setPaymentMethod(text2.toUpperCase(), text.toUpperCase());
						} else if (value == 2) {
							Sell.setAndVerifyCPF("Nao informado");
							paySystemLn();
							text = entry.next();
							System.out.println("Digite os dados do metodo de pagemento");
							String text2 = entry.next();

						} else {
							System.out.println("Valor invalido");
						}

						System.out.println(Sell.sellStockTestAndBuy(Stock, cash));
					} else if (value == 4) {
						System.out.println("Cancelando sua compra");
						Sell.cancel();
					}
					if (value == 5) {
						y = false;
						System.out.println("Retornando ao menu anterior");

					} else {
						System.out.println("Digite o valor correto");

					}
				}

			} else if (value == 4) {
				System.out.println(cash.getCashRegisterData());
			} else if (value == 5) {
				System.out.println("Desligando os Sistemas");
				x = false;
			} else {
				System.out.println("Digite o valor correto");
			}

		}
	}

}
