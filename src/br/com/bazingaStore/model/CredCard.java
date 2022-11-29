package br.com.bazingaStore.model;

public class CredCard implements PaymentMethod {
	String NumberOfCredCard;
	public CredCard() {
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
		return " CredCard [Numero do Cartao=" + NumberOfCredCard + "]";
	}
	

}
