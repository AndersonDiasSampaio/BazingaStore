package br.com.bazingaStore.model;

public class CashRegister {
	Double ValueInRegister;
	public CashRegister() {
		this.ValueInRegister=0d;
	}
	public Double getValueInRegister() {
		return ValueInRegister;
	}
	public void setValueInRegister(Double valueInRegister) {
		this.ValueInRegister = valueInRegister + this.ValueInRegister;
	}
	
}
