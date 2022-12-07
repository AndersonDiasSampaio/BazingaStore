package br.com.bazingaStore.comunication;

import java.util.List;
import java.util.Scanner;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;
import br.com.bazingaStore.service.CashRegisterService;
import br.com.bazingaStore.service.SellService;
import br.com.bazingaStore.service.StockService;

public class StoreComunication {
	String description;
	int quantity;
	Double price;
	int sku;
	public void historyOfSell(SellService sell) {
		List a = (List) sell.getSellDataList();
		System.out.println("Historico de vendas: ");

		for (int x=0; x<a.size();x++) {
			Sell sell1 = (Sell) a.get(x);
			System.out.println(x+1+" - "+sell1.toString());
		}
		
	}
	public void paySystemLn() {
		System.out.println("Digite o metodo de pagamento");
		System.out.println("DINHEIRO");
		System.out.println("DEBITO");
		System.out.println("CREDCARD");
		System.out.println("PIX");
	}

	public void firstMenu() {
		System.out.println("Bem vindo ao Sistema de Gerenciamento e venda de Roupas Bazinga");
		System.out.println("1 - Para Adicionar ao estoque");
		System.out.println("2 - Para Verificar Stock ");
		System.out.println("3 - Para Venda de Roupas ");
		System.out.println("4 - para ver o caixa");
		System.out.println("5 - para sair");
	}

	public void secondMenu() {
		System.out.println("1 - para listar Roupas");
		System.out.println("2 - selecionar Roupas");
		System.out.println("3 - para Finalizar a compra");
		System.out.println("4 - para cancelar a compra");
		System.out.println("5 - para voltar ao menu anterior");
	}

	public void cpfMenu() {
		System.out.println("Deseja salvar o CPF? ");
		System.out.println("1 - para Sim");
		System.out.println("2 - para nao");
		System.out.println("3 - para voltar ao menu anterior");

	}

	public void cashRegisterMenu() {
		System.out.println("1 - para verificar o caixa");
		System.out.println("2 - para verificar o historico de compras");
		System.out.println("3 - para voltar ao menu anterior");

	}
	public StoreComunication() {
		boolean x = true;
		SellService sell = new SellService();
		StockService stock = new StockService();
		CashRegisterService cash = new CashRegisterService();

		Scanner entry = new Scanner(System.in);
		int value = 0;

		while (x == true) {
			firstMenu();

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
				System.out.println(stock.registProduct(quantity, price, description, sku));

			} else if (value == 2) {
				System.out.println(stock.listProduct());

			} else if (value == 3) {
				boolean y = true;
				while (y == true) {

					secondMenu();
					value = entry.nextInt();
					if (value == 1) {
						System.out.println(stock.listProduct());
					} else if (value == 2) {
						System.out.println("Digite o SKU do produto");
						this.sku = entry.nextInt();
						System.out.println("Digite a quantidade do produto");
						this.quantity = entry.nextInt();
						
						System.out.println(sell.addProductCard(stock.returnProductInStock(this.sku), this.quantity));

					} else if (value == 3) {
						//EDITAR PRA O CPF SER SETADO VIA SELLSTOCKTESTANDBUY
						String text;
						boolean auxCPF=true;
						while(auxCPF==true) {
						cpfMenu();
						value = entry.nextInt();

						if (value == 1) {
							System.out.println("Digiteo valor do CPF");
							text = entry.next();
							sell.setAndVerifyCPF(text);
							paySystemLn();
							text = entry.next();
							System.out.println("Digite os dados do metodo de pagemento");
							String text2 = entry.next();
							System.out.println(text2);

							sell.setPaymentMethod(text.toUpperCase(), text2.toUpperCase());
							System.out.println(sell.sellStockTestAndBuy(stock, cash));
							auxCPF=false;

						} else if (value == 2) {
							sell.setAndVerifyCPF("Nao informado");
							paySystemLn();
							text = entry.next();
							System.out.println("Digite os dados do metodo de pagemento");
							String text2 = entry.next();
							System.out.println(text2);
							sell.setPaymentMethod(text.toUpperCase(), text2.toUpperCase());
							System.out.println(sell.sellStockTestAndBuy(stock, cash));
							auxCPF=false;

						}else if(value==3) {
							auxCPF=false;
						} else {
							System.out.println("Valor invalido");
						}}

					} else if (value == 4) {
						System.out.println("Cancelando sua compra");
						sell.cancel();
					}
					else if (value == 5) {
						y = false;
						System.out.println("Retornando ao menu anterior");

					} else {
						System.out.println("Digite o valor correto");

					}
				}

			} else if (value == 4) {
				Boolean auxBol = true;
				while (auxBol == true) {
					cashRegisterMenu();
					value = entry.nextInt();

					if (value == 1) {

						System.out.println("Valor em caixa: R$" + cash.getCash(sell.getSellData().listItens()));

					} else if (value == 2) {
						historyOfSell(sell);

					} else if (value == 3) {
						System.out.println("Retornando ao menu anterior");
						auxBol=false;

					}else {
						System.out.println("Digite o valor correto");

					}
				}
			} else if (value == 5) {
				System.out.println("Desligando os Sistemas");
				x = false;
			} else {
				System.out.println("Digite o valor correto");
			}

		}
	}

}
