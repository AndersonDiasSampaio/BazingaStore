package br.com.bazingaStore.model;

public class Pix implements PaymentMethod {
	String pix;
	public Pix() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void TypeOfPayment(String value) {
		// TODO Auto-generated method stub
		this.pix=value;
	}

}
