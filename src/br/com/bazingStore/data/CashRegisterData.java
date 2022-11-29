package br.com.bazingStore.data;

import java.util.List;

import br.com.bazingaStore.model.CashRegister;

public class CashRegisterData implements DataInterface {
	CashRegister cashRegister;

	public CashRegisterData() {
		// TODO Auto-generated constructor stub
		this.cashRegister = new CashRegister();
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Object obj) {
		this.cashRegister.setValueInRegister((Double) obj);

	}

	@Override
	public List<Object> listItens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItem(Object obj) {

		// TODO Auto-generated method stub
		return null;
	}

	public Double getCash() {
		return this.cashRegister.getValueInRegister();

	}
}
