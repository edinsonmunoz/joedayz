package com.onlinestore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlinestore.bo.ProductoBO;
import com.onlinestore.model.Producto;

/**
 * Controller para manejar la busqueda y listado de productos
 */
@Controller
@RequestMapping("/listarProductos.htm")
public class ProductoController {

	private ProductoBO productoBO;

	@Autowired
	public ProductoController(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}

	/**
	 * Resumen.
	 * Método que permite realizar la carga inicial de productos disponibles
	 * en la grilla de búsqueda
	 * @author 	: Edinson Muñoz Guia
	 * @return
	 */
	/*@RequestMapping(method = RequestMethod.GET)
	public @ModelAttribute("productos")List<Producto> listarProductos() {
		System.out.println("Productos: "+productoBO.listarProductos("").size());
		return productoBO.listarProductos("");
	}*/
	
	@RequestMapping( method = RequestMethod.GET)//value="/listarProductos.htm"
	public ModelAndView listarProductos (HttpServletRequest request) throws ServletRequestBindingException{
		ModelAndView mav = new ModelAndView();
		List<Producto> listaProductos = productoBO.listarProductos("");
		mav.setViewName("listarProductos");
		mav.addObject("productos", listaProductos);
		return mav;
	}
	
	
	/*@RequestMapping(method = RequestMethod.POST)
	public ModelAndView listarProductos(HttpServletRequest request) throws ServletRequestBindingException {
		String nombre = ServletRequestUtils.getRequiredStringParameter(request,"nombre");
		System.out.println("Nombre: " + nombre);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productos", productoBO.listarProductos(nombre));
		mav.setViewName("redirect:listarProductos.htm");
		
		System.out.println("BUSQ: "+productoBO.listarProductos(nombre).size());
		
		return mav;
	}*/
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView buscarProductos(HttpServletRequest request) throws ServletRequestBindingException {
		//System.out.println("BUSQUEDA");
		String nombre = ServletRequestUtils.getRequiredStringParameter(request,"nombre");
		//System.out.println("Nombre: " + nombre);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productos", productoBO.listarProductos(nombre));
		mav.setViewName("listarProductos");
		//System.out.println("BUSQ: "+productoBO.listarProductos(nombre).size());
		
		return mav;
	}
	
	
	
	
	
	
	
}
