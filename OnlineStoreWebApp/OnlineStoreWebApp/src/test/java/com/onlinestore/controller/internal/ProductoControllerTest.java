package com.onlinestore.controller.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.onlinestore.controller.EditarProductoController;
import com.onlinestore.controller.ProductoController;


@RunWith(JUnit4.class)
public class ProductoControllerTest {
	
	private ProductoController controller;

	@Before
	public void setUp() throws Exception {
		controller = new ProductoController(new StubProductoBOImpl());
	}

	/*@Test
	public void testHandleSummaryRequest() throws Exception {
		List<Producto> productos = controller.listarProductos(request)
		assertEquals(1, products.size());
	}*/
}