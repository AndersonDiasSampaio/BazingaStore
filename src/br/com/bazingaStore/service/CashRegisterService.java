package br.com.bazingaStore.service;

import br.com.bazingStore.data.CashRegisterData;

public class CashRegisterService {
	CashRegisterData cashRegisterData;
	public CashRegisterService() {
		// TODO Auto-generated constructor stub
		this.cashRegisterData= new CashRegisterData();
	}
	public Double getCashRegisterData() {
		return cashRegisterData.getCash();
	}
	public void setCashRegisterData(Double cashRegisterData) {
		this.cashRegisterData.save(cashRegisterData);
	}
	

}
