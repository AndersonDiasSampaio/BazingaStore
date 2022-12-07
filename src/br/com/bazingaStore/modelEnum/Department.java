package br.com.bazingaStore.modelEnum;

import java.util.HashMap;
import java.util.Map;

public enum Department {
VERAO("VER", 11), INVERNO("INV", 12), OUTONO("OUT", 13), PRIMAVERA("PRI", 14);


private int skuCod;
private String cod;


private final static Map<String, Department> map= new HashMap<>();
private final static Map<Integer, Department> map2= new HashMap<>();
static {
	for(Department department: Department.values()) {
		map.put(department.getCod(), department);
	}
}
static {
	for(Department department: Department.values()) {
		map2.put(department.getSkuCod(), department);
	}
}
Department(String string, int i) {
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

public static Department getType(String a) {
	return map.get(a);
}
public static Department getType(int a) {
	return map2.get(a);
}
}
