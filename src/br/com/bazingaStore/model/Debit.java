package br.com.bazingaStore.model;

public class Debit implements PaymentMethod {
	String NumberOfCredCard;

	public Debit() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void TypeOfPayment(String value) {
		// TODO Auto-generated method stub
		this.NumberOfCredCard=value;


	}

	public String getNumberOfCredCard() {
		return NumberOfCredCard;
	}

	@Override
	public String toString() {
		return " Debito [Numero do cartao de credito=" + NumberOfCredCard + "]";
	}
	

}
