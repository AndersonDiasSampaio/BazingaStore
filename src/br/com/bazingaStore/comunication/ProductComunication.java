package br.com.bazingaStore.comunication;

import java.util.Scanner;

import br.com.bazingaStore.model.Product;
import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Type;
import br.com.bazingaStore.service.StockService;

public class ProductComunication {
	StockService productService = new StockService();
	Scanner Sc = new Scanner(System.in);
	Integer quantity;
	Double price;
	String department;
	String description;
	Color color;
	Type type;
	Size Size;
	Category category;
	int Sku;

	public ProductComunication() {
		// TODO Auto-generated constructor stub
	}

	public void addProductComunication() {
		System.out.println("Digite os seguintes dados para cadastro do produto:");
		System.out.println("Quantidade");
		this.quantity = this.Sc.nextInt();
		System.out.println("Preço");
		this.price = this.Sc.nextDouble();
		System.out.println("Departamento");
		this.department = this.Sc.next();
		System.out.println("Descricao");
		this.description = this.Sc.next();
		System.out.println("SKU");
		Sku = this.Sc.nextInt();
		/*
		 * System.out.println("Cor"); this.color = Color.valueOf(Sc.next());
		 * System.out.println("Type"); this.type = Type.valueOf(Sc.next());
		 * System.out.println("Size"); this.category = Category.valueOf(Sc.next());
		 *
		 */
		Product product = new Product(quantity, price, department, description,
				Sku /* , color, type, Size, category, Sku */);

		this.productService.registProduct(quantity, price, department, description, null, null, null, category, Sku);
	}

	/*public List<Object> returnStockService() {
		return this.productService.getDataStock().listItens();
	}
*/
}
