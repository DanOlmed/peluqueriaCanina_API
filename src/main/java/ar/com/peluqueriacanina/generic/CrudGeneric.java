package ar.com.peluqueriacanina.generic;

import java.util.List;

public interface CrudGeneric <T>{
	
	   public T findById(int id);
	   public T save(T model);
	   public List<T> findAll(int id);
	   public List<T> findAll();
	   public Boolean delete(int id);
	   public T update(T model);
	
	
	
	

}
