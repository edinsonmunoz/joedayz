package com.onlinestore.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.bo.ProductoBO;
import com.onlinestore.dao.ProductoDAO;
import com.onlinestore.model.Producto;

@Service("ProductoBO")
public class ProductoBOImpl implements ProductoBO {

	@Autowired
	private ProductoDAO productoDAO;
	
	public List<Producto> listarProductos(String descripcion){
		return productoDAO.listarProductos(descripcion);
	}
	
	public Producto obtenerProducto(int idProducto) {
        return productoDAO.obtenerProducto(idProducto);
    }
	
	public void editarProducto(Producto producto) {
        productoDAO.editarProducto(producto);
    }
	
	public void eliminarProducto(int idProducto) {
        productoDAO.eliminarProducto(idProducto);
    }
	
	public void crearProducto(Producto producto) {
        productoDAO.crearProducto(producto);
    }
	
	public boolean existeProducto(int idProducto, String nombre){
		return productoDAO.existeProducto(idProducto, nombre);
	}
	
}
