package br.com.bazingaStore.modelEnum;

import java.util.HashMap;
import java.util.Map;

public enum Color {
PRETA("PR", 11), VERMELHA("VER", 12), AZUL("AZU", 13), VERDE("VER", 14);

private String cod;
private int skuCod;

private final static Map<String, Color> map= new HashMap<>();
private final static Map<Integer, Color> map2= new HashMap<>();
static {
	for(Color color: Color.values()) {
		map.put(color.getCod(), color);
	}
}
static {
	for(Color color: Color.values()) {
		map2.put(color.getSkuCod(), color);
	}
}

Color(String string, int i) {
	// TODO Auto-generated constructor stub
	this.cod=string;
	this.skuCod=i;
}
public String getCod() {
	return cod;
}

public int getSkuCod() {
	return skuCod;
}

public static Color getType(String a) {
	return map.get(a);
}
public static Color getType(int a) {
	return map2.get(a);
}

}
