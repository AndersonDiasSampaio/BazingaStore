package br.com.bazingaStore.model;

public class Cash implements PaymentMethod {
	String NoBank;
	public Cash() {
		this.NoBank="pagamento em dinheiro";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void TypeOfPayment(String value) {
		// TODO Auto-generated method stub

	}

	public String getNoBank() {
		return NoBank;
	}

	@Override
	public String toString() {
		return " [Dinheiro=" + NoBank + "]";
	}
	

}
