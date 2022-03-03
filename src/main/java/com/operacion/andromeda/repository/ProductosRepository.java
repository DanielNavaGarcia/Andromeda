package com.operacion.andromeda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.ProductosModel;

@Repository
public interface ProductosRepository extends CrudRepository<ProductosModel, Integer> {
	List<ProductosModel> findByCategoriaContaining(String categoria);
}
