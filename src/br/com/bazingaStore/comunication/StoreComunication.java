package br.com.bazingaStore.comunication;

import java.util.List;
import java.util.Scanner;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.model.Sell;
import br.com.bazingaStore.service.CashRegisterService;
import br.com.bazingaStore.service.SellService;
import br.com.bazingaStore.service.StockService;
import br.com.bazingaStore.util.CpfCheck;

public class StoreComunication {
	String description;
	int quantity;
	Double price;
	int sku;

	public void historyOfSell(SellService sell) {
		List a = (List) sell.getSellDataList();
		System.out.println("Historico de vendas: ");

		for (int x = 0; x < a.size(); x++) {
			Sell sell1 = (Sell) a.get(x);
			System.out.println(x + 1 + " - " + sell1.toString());
		}

	}

	public void paySystemLn() {
		System.out.println("Digite o metodo de pagamento");
		System.out.println("DINHEIRO");
		System.out.println("CARTAO_DE_DEBITO");
		System.out.println("CARTAO_DE_CREDITO");
		System.out.println("PIX");
	}

	public void firstMenu() {
		System.out.println("Bem vindo ao Sistema de Gerenciamento e venda de Roupas Bazinga");
		System.out.println("1 - ACESSAR O ESTOQUE");
		System.out.println("2 - ACESSAR O SISTEMA DE COMPRAS");
		System.out.println("3 - ACESSAR O CAIXA");
		System.out.println("4 - SAIR");
	}
	public void stockMenu() {
		System.out.println("1 - ADICIONAR PRODUTOS AO ESTOQUE");
		System.out.println("2 - VERIFICAR O ESTOQUE");
		System.out.println("3 - RETORNAR AO MENU ANTERIOR");

	}

	public void secondMenu() {
		System.out.println("1 - Listar Roupas do estoque");
		System.out.println("2 - selecionar Roupas");
		System.out.println("3 - Listar Roupas do carrinho de compras");
		System.out.println("4 - Finalizar a compra");
		System.out.println("5 - Cancelar a compra");
		System.out.println("6 - Voltar ao menu anterior");
	}

	public void cpfMenu() {
		System.out.println("Deseja salvar o CPF? ");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		System.out.println("3 - Voltar ao menu anterior");

	}

	public void cashRegisterMenu() {
		System.out.println("1 - Verificar o caixa");
		System.out.println("2 - Verificar o historico de compras");
		System.out.println("3 - Voltar ao menu anterior");

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
				Boolean auxStock=true;
				while(auxStock==true) {
				stockMenu();
				value = entry.nextInt();

				if(value==1) {
					System.out.println("Digite a descricao do produto");
					this.description = entry.next();
					System.out.println("Digite a quantidade do produto");
					this.quantity = entry.nextInt();
					System.out.println("Digite o preco do produto");
					this.price = entry.nextDouble();
					System.out.println("Digiteo SKU");
					this.sku = entry.nextInt();
					System.out.println(stock.registProduct(quantity, price, description, sku));
				}else if(value==2) {
					System.out.println(stock.listProduct());

				}else if(value==3) {
					auxStock=false;
				}else {
					System.out.println("Digite o valor correto");

				}
			}

			}  else if (value == 2) {
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

					} else if(value==3) {
						System.out.println(sell.productIncardToSell());
					}
					else if (value ==4 ) {
						// EDITAR PRA O CPF SER SETADO VIA SELLSTOCKTESTANDBUY
						String text;
						String valueCPF = "", valueCardNumber, valueCardValidity, valueBancaryData = "";
						boolean auxCPF = true;
						while (auxCPF == true) {
							cpfMenu();
							value = entry.nextInt();

							if (value == 1) {
								Boolean j = false;
								CpfCheck t = new CpfCheck();
								while (j == false) {
									System.out.println("Digiteo valor do CPF");
									valueCPF = entry.next();
									j = t.cpfTest(valueCPF);
								}

								paySystemLn();
								text = entry.next();

								if (text.toUpperCase().equals("CARTAO_DE_DEBITO")
										|| text.toUpperCase().equals("CARTAO_DE_CREDITO")) {
									System.out.println("Digite o Numero do cartao");
									valueCardNumber = entry.next();
									System.out.println("Digite a data de validade do cartao");
									valueCardValidity = entry.next();
									valueBancaryData = "Numero do Cartao: " + valueCardNumber + " Validade: "
											+ valueCardValidity;

								} else if (text.toUpperCase().equals("PIX")) {
									System.out.println("Digite a chave pix");
									valueBancaryData = entry.next();
								} else if (text.toUpperCase().equals("DINHEIRO")) {

								}

								// sell.setPaymentMethod(text.toUpperCase(), valueBancaryData.toUpperCase());

								System.out.println(sell.sellStockTestAndBuy(stock, cash, valueCPF, text.toUpperCase(),
										valueBancaryData.toUpperCase()));
								sell.cancel();
								auxCPF = false;

							} else if (value == 2) {
								paySystemLn();
								text = entry.next();
								if (text.toUpperCase().equals("CARTAO_DE_DEBITO")
										|| text.toUpperCase().equals("CARTAO_DE_CREDITO")) {
									System.out.println("Digite o Numero do cartao");
									valueCardNumber = entry.next();
									System.out.println("Digite a data de validade do cartao");
									valueCardValidity = entry.next();
									valueBancaryData = "Numero do Cartao: " + valueCardNumber + " Validade: "
											+ valueCardValidity;

								} else if (text.toUpperCase().equals("PIX")) {
									System.out.println("Digite a chave pix");
									valueBancaryData = entry.next();
								} else if (text.toUpperCase().equals("DINHEIRO")) {
									valueBancaryData = "Nao informado";
								}

								System.out.println(sell.sellStockTestAndBuy(stock, cash, valueBancaryData,
										text.toUpperCase(), valueBancaryData.toUpperCase()));
								auxCPF = false;

							} else if (value == 3) {
								auxCPF = false;
							} else {
								System.out.println("Valor invalido");
							}
						}

					} else if (value == 5) {
						System.out.println("Cancelando sua compra");
						sell.cancel();
					} else if (value == 6) {
						y = false;
						System.out.println("Retornando ao menu anterior");

					} else {
						System.out.println("Digite o valor correto");

					}
				}

			} else if (value == 3) {
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
						auxBol = false;

					} else {
						System.out.println("Digite o valor correto");

					}
				}
			} else if (value == 4) {
				System.out.println("Desligando os Sistemas");
				x = false;
			} else {
				System.out.println("Digite o valor correto");
			}

		}
	}

}
