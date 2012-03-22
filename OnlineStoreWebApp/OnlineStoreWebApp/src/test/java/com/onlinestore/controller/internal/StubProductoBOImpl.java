package com.onlinestore.controller.internal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.onlinestore.bo.ProductoBO;
import com.onlinestore.model.Producto;

/**
 * A dummy implementation of an account manager storing all account data in memory. Useful for testing only.
 */
public class StubProductoBOImpl implements ProductoBO {

	private Map<Long, Producto> productosById = new HashMap<Long, Producto>();

	public StubProductoBOImpl() {
		Producto producto1 = new Producto(20, "THINKPAD 32GB", "THINKPAD 32GB DESCRIPCION", new BigDecimal("1500.0"),
				"THINKPAD32GB", 2);
		productosById.put(producto1.getIdProducto(), producto1);
	}

	@Override
	public List<Producto> listarProductos(String nombre) {
		return new ArrayList<Producto>(productosById.values());
	}

	@Override
	public Producto obtenerProducto(int idProducto) {
		Producto producto = productosById.get(new Long(idProducto));
		return producto;
	}

	@Override
	public void editarProducto(Producto producto) {
		productosById.put(producto.getIdProducto(), producto);
		
	}

	@Override
	public void eliminarProducto(int idProducto) {
		productosById.remove(new Long(idProducto));		
	}

	@Override
	public void crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeProducto(int idProducto, String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
