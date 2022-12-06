package br.com.bazingaStore.modelEnum;

import java.util.HashMap;
import java.util.Map;

public enum Type {
	BLUSA("BLU", 11),
	CALSA("CAL", 12),
	CAMISA("CAM", 13),
	MEIA("MEI",14);
	
	private final static Map<String, Type> map= new HashMap<>();
	private final static Map<Integer, Type> map2= new HashMap<>();

	static {
		for(Type type: Type.values()) {
			map.put(type.getCod(), type);
		}
	}
	static {
		for(Type type: Type.values()) {
			map2.put(type.getSkuCod(), type);
		}
	}
	
	String cod;
	int skuCod;
	
	Type(String cod, int skuCod) {
	this.cod = cod;
	this.skuCod= skuCod;
	}

	public String getCod() {
		return cod;
	}

	public int getSkuCod() {
		return skuCod;
	}
	
	public static Type getType(String a) {
		return map.get(a);
	}
	public static Type getType(int a) {
		return map2.get(a);
	}
}
