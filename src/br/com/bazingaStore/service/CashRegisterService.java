package br.com.bazingaStore.service;

import java.util.List;

import br.com.bazingaStore.model.Sell;
import br.com.bazingaStore.modelEnum.Size;

public class CashRegisterService {

	public Double getCash(List<Object> SellData) {
		Double a=0d;
		Sell sell= new Sell();
		for(int x=0;x< SellData.size();x++) {
			sell=(Sell) SellData.get(x);
			a=sell.getPrice()+a;
		}
		return a;
	}
	
}
