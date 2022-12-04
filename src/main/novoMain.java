package main;

import java.util.Scanner;

import br.com.bazingaStore.comunication.StoreComunication;
import br.com.bazingaStore.modelEnum.Type;

public class novoMain {

	public novoMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StoreComunication a = new StoreComunication();
		for (Type type : Type.values()) {
			System.out.println(type.getSkuCod()+"/");
		}
		Scanner entry = new Scanner(System.in);
		int a = entry.nextInt();
		Type tipo= Type.getType(a);
		System.out.println(tipo);
	}

}
