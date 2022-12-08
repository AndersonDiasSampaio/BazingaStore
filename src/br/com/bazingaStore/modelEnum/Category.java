package br.com.bazingaStore.modelEnum;

import java.util.HashMap;
import java.util.Map;

public enum Category {
MASCULINO("Masc", 11), FEMININO("FEM", 12), INFANTIL("INF", 13), IDOSO("IDO", 14);


private String cod;
private int skuCod;

private final static Map<String, Category> map= new HashMap<>();
private final static Map<Integer, Category> map2= new HashMap<>();

static {
	for(Category category: Category.values()) {
		map.put(category.getCod(), category);
	}
}
static {
	for(Category category: Category.values()) {
		map2.put(category.getSkuCod(), category);
	}
}
Category(String cod, int skuCod) {
	// TODO Auto-generated constructor stub
	this.cod=cod;
	this.skuCod=skuCod;
}


public String getCod() {
	return cod;
}

public int getSkuCod() {
	return skuCod;
}

public static Category getType(String a) {
	return map.get(a);
}
public static Category getType(int a) {
	return map2.get(a);
}
}
