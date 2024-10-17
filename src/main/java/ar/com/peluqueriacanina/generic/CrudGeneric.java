package ar.com.peluqueriacanina.generic;

import java.util.List;

public interface CrudGeneric <T>{
	
	   public T findById(Long id);
	   public T save(T model);
	   public List<T> findAll(Long id);
	   public List<T> findAll();
	   public Boolean delete(Long id);
	   public T update(T model);
	
	
	
	

}
