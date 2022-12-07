package br.com.bazingaStore.model;

import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Department;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Type;

public class Product {
	private int Sku;
	private Integer quantity;
	private Double price;
	private String description;
	
	
	private Department department;
	private Color color;
	private Type type;
	private Size size;
	private Category category;


	public Product(Integer quantity, Double price, String description, Integer Sku) {
		this.quantity = quantity;
		this.price = price;
		this.Sku = Sku;
		this.description = description;
		String k = Sku.toString();
		
			String a = Sku.toString();
			String b = Sku.toString();
			String c = Sku.toString();
			String d = Sku.toString();
			String e = Sku.toString();

			a = a.substring(0, 2);
			b = b.substring(2, 4);
			c = c.substring(4, 6);
			d = d.substring(6, 8);
			e= e.substring(8,10);
			int a1 = Integer.parseInt(a);
			int b1 = Integer.parseInt(b);
			int c1 = Integer.parseInt(c);
			int d1 = Integer.parseInt(d);
			int e1=Integer.parseInt(e);
			Type type = Type.getType(a1);
			Color color = Color.getType(b1);
			Size size= Size.getType(c1);
			Category category = Category.getType(d1);
			Department department= Department.getType(e1);

			setType(type);
			setColor(color);
			setSize(size);
			setCategory(category);
			setDepartment(department);
		

	}

	public Product() {

	}

	public int getSku() {
		return Sku;
	}

	public void setSku(int sku) {
		this.Sku = sku;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "\n" + " Quantidade=" + quantity + ", Preco=" + price + ", Departamento=" + department + ", Descricao="
				+ description + ", Cor=" + color + ", Tipo=" + type + ", Tamanho=" + size + ", Categoria=" + category
				+ ", Identificador Unico=" + Sku + "" + "\n";
	}

}
