package br.com.bazingStore.data;

import java.util.List;

import br.com.bazingaStore.model.Product;

public interface DataInterface {

	public void delete(Product Product);
	public void update(Product Product);
	public void save(Product Product);
}

