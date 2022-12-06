package br.com.bazingaStore.model;

import br.com.bazingaStore.modelEnum.Category;
import br.com.bazingaStore.modelEnum.Color;
import br.com.bazingaStore.modelEnum.Size;
import br.com.bazingaStore.modelEnum.Type;

public class Product {

	private Integer quantity;
	private Double price;
	private String department;
	private String description;

	private Color color;
	private Type type;
	private Size Size;
	private Category category;
	private int Sku;
	/*
	 * Color color, Type type, br.com.bazingaStore.modelEnum.Size size, Category
	 * category, br.com.bazingaStore.modelEnum.Sku sku
	 */

	public Product(Integer quantity, Double price, String department, String description, int sku) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.department = department; //todos colocar como Enum
		this.description = description;
		this.Sku = sku;
		/*
		 * this.color = color; this.type = type; Size = size; this.category = category;
		 * Sku = sku;
		 */
	}

	public Product(Integer quantity, Double price, String description, Integer Sku) {
		this.quantity = quantity;
		this.price = price;
		this.Sku = Sku;
		this.description=description;
		String k = Sku.toString();
		if(k.length()==8) {
		String a = Sku.toString();
		String b= Sku.toString();
		String c=  Sku.toString();
		String d=  Sku.toString();
		a=a.substring(0,2);
		b=b.substring(2, 4);
		c=c.substring(4, 6);
		d=d.substring(6,8);
		int a1=Integer.parseInt(a);
		int b1=Integer.parseInt(b);
		int c1=Integer.parseInt(c);
		int d1=Integer.parseInt(d);
		Type type= Type.getType(a1);
		Color color = Color.getType(b1);
		Size size= Size.getType(c1);
 
		setType(type);
		setColor(color);
		setSize(size);}
		
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
		return Size;
	}

	public void setSize(Size size) {
		Size = size;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "\n" + " quantity=" + quantity + ", price=" + price + ", department=" + department + ", description="
				+ description + ", color=" + color + ", type=" + type + ", Size=" + Size + ", category=" + category
				+ ", Sku=" + Sku + "" + "\n";
	}

}
