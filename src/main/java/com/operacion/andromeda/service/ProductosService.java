package com.operacion.andromeda.service;

import java.util.ArrayList;
import java.util.Optional;

import com.operacion.andromeda.model.ProductosModel;

public interface ProductosService {
	ArrayList<ProductosModel> obtenerTodosProductos();
	ProductosModel guardarProducto(ProductosModel productosModel);
	boolean eliminarProducto(Integer id);
	Optional<ProductosModel> encontrarProducto(Integer id);
	ArrayList<ProductosModel> encontrarCategoria(String categoria);
}
