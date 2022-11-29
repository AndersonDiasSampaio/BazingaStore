package br.com.bazingaStore.model;

public class Pix implements PaymentMethod {
	String codepix;
	

	public Pix() {
	}

	@Override
	public void TypeOfPayment(String value) {
		// TODO Auto-generated method stub
		this.codepix=value;
	}
	@Override
	public String toString() {
		return "Pix [Chave PIX=" + codepix + "]";
	}


}
