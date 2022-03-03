package com.operacion.andromeda.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operacion.andromeda.model.ProductosModel;
import com.operacion.andromeda.repository.ProductosRepository;

@Service
public class ProductosServiceImp implements ProductosService {
	private final ProductosRepository productosRepository;
	
	public ProductosServiceImp(@Autowired ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}
	
	public ArrayList<ProductosModel> obtenerTodosProductos(){
		return (ArrayList<ProductosModel>) productosRepository.findAll();
	}
	
	public ProductosModel guardarProducto(ProductosModel productosModel) {
		return productosRepository.save(productosModel);
	}
	
	public boolean eliminarProducto(Integer id) {
		try {
			productosRepository.deleteById(id);
			return true;
		} catch(Exception error) {
			return false;
		}
	}	
	
	public Optional<ProductosModel> encontrarProducto(Integer id) {
		try {
			return productosRepository.findById(id);
		}catch (Exception error) {
			return Optional.empty();
		}
	}
	

	public ArrayList<ProductosModel> encontrarCategoria(String categoria) {
        return (ArrayList<ProductosModel>) productosRepository.findByCategoriaContaining(categoria);
	}
	
}