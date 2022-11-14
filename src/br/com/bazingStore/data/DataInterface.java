package br.com.bazingStore.data;

import java.util.List;

import br.com.bazingaStore.model.Product;

public interface DataInterface {

	public boolean delete(Object obj);
	public void update(Object obj);
	public void save(Object obj);
	List<Object> listItens();
	Object getItem(Object obj);
	
}

