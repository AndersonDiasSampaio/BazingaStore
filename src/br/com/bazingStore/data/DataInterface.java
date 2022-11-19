package br.com.bazingStore.data;

import java.util.List;

public interface DataInterface {

	public boolean delete(Object obj);
	public void update(Object obj);
	public void save(Object obj);
	List<Object> listItens();
	Object getItem(Object obj);

}

