package com.onlinestore.dao;

import java.util.List;

import com.onlinestore.model.Producto;

public interface ProductoDAO {

	public List<Producto> listarProductos(String descripcion);
	public Producto obtenerProducto(int idProducto);
	public void editarProducto(Producto producto);
	public void eliminarProducto(int idProducto);
	public void crearProducto(Producto producto);
	public boolean existeProducto(int idProducto, String nombre);
	
}
