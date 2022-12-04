package br.com.bazingaStore.modelEnum;

import java.util.HashMap;
import java.util.Map;

public enum Size {
	PEQUENO("P", 1), MEDIO("M", 2), GRANDE("G", 3), EXTRAGRANDE("GG", 4);

	private int skuCod;
	private String cod;


	private final static Map<String, Size> map= new HashMap<>();
	private final static Map<Integer, Size> map2= new HashMap<>();
	static {
		for(Size size: Size.values()) {
			map.put(size.getCod(), size);
		}
	}
	static {
		for(Size size: Size.values()) {
			map2.put(size.getSkuCod(), size);
		}
	}
	
	Size(String string, int i) {
		// TODO Auto-generated constructor stub
		this.cod= string;
		this.skuCod= i;
	}
	public String getCod() {
		return cod;
	}

	public int getSkuCod() {
		return skuCod;
	}
	
	public static Size getType(String a) {
		return map.get(a);
	}
	public static Size getType(int a) {
		return map2.get(a);
	}
}
