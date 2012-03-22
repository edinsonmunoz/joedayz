package com.onlinestore.bo.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.onlinestore.bo.ProductoBO;
import com.onlinestore.model.Producto;

@ContextConfiguration(locations = { "classpath:com/onlinestore/internal/system-test-config.xml" })
public class ProductoBOImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	Logger log = Logger.getLogger(ProductoBOImplTest.class);

	@Autowired
	private ProductoBO productoBO;

	@Test
	public void testListarProductos() {
		List<Producto> productos = productoBO.listarProductos("%IP%");
		assertEquals("no coincide el numero de productos totales", 3,
				productos.size());
	}

	@Test
	public void testObtenerProducto() {
		Producto producto = productoBO.obtenerProducto(2);
		assertNotNull("se retorno un objeto nulo", producto);
	}

	@Test
	public void testEditarProducto() {
		Producto producto1 = new Producto(13, "LENOVO 32GB", "LENOVO 32GB DESCRIPCION", new BigDecimal("1500.0"),
				"LENOVO32GB", 2);
		productoBO.editarProducto(producto1);
		Producto producto2 = productoBO.obtenerProducto(13);
		assertEquals("No son iguales en la edicion", producto1.getNombre(),
				producto2.getNombre());
	}

	@Test
	public void testEliminarProducto() {
		productoBO.eliminarProducto(2);
		List<Producto> productos = productoBO.listarProductos("%%");
		assertEquals("se retorno un objeto no nulo", 10, productos.size());
	}

}