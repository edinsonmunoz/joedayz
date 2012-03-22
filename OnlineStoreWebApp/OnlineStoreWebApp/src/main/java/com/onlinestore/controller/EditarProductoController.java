package com.onlinestore.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinestore.bo.CategoriaBO;
import com.onlinestore.bo.ProductoBO;
import com.onlinestore.controller.validator.ProductoValidator;
import com.onlinestore.model.Categoria;
import com.onlinestore.model.Producto;

/**
 * Controller para manejar el ingreso de valores a formulario de 
 * creacion y edicion de productos
 */
@Controller
@RequestMapping("/detalleProducto.htm")
@SessionAttributes("producto")
public class EditarProductoController {

	private ProductoBO productoBO;
	private CategoriaBO categoriaBO;
	private ProductoValidator productoValidator;

	@Autowired
	public EditarProductoController(ProductoBO productoBO,
			CategoriaBO categoriaBO ) {
		this.productoBO = productoBO;
		this.categoriaBO = categoriaBO;
		productoValidator = new ProductoValidator(productoBO);
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> listarCategorias(){
		return categoriaBO.listarCategorias();
	}

	/*public void cargarListaCategorias(HttpServletRequest request) {
		List<Categoria> categorias = categoriaBO.listarCategorias();
		request.setAttribute("categorias", categorias);
	}*/

	/**
	 * Resumen. Método que permite obtener los datos del producto seleccionado
	 * 
	 * @author : Edinson Muñoz Guia
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView verDetalleProducto(HttpServletRequest request)
			throws ServletRequestBindingException {
		Producto producto = new Producto();
		producto.setNuevo(true);
		ModelAndView mav = new ModelAndView();
		String idProducto = request.getParameter("productoId"); //ServletRequestUtils.getRequiredIntParameter(request,"productoId");
		if(idProducto!=null){
			producto = productoBO.obtenerProducto(Integer.parseInt(idProducto));
			producto.setPrecioString(producto.getPrecio()+"");
			producto.setNuevo(false);
		}
		mav.addObject("producto", producto);
		mav.setViewName("detalleProducto");
		return mav;
	}

	@RequestMapping(params = "editar", method = RequestMethod.POST)
	public String editarProducto(@ModelAttribute("producto") Producto producto,
			BindingResult result, SessionStatus status) {
		productoValidator.validate(producto, result);
		if (result.hasErrors()) {
			return "detalleProducto";
		}
		//System.out.println("EDITANDO ...");
		producto.setPrecio(new BigDecimal(producto.getPrecioString()));
		productoBO.editarProducto(producto);
		status.setComplete();
		return "redirect:/productos/listarProductos.htm";
	}

	@RequestMapping(params = "eliminar", method = RequestMethod.POST)
	public String eliminarProducto(
			@ModelAttribute("producto") Producto producto,
			BindingResult result, SessionStatus status) {
		//System.out.println("ELIMINANDO ...");
		long idProducto = producto.getIdProducto();
		productoBO.eliminarProducto(Integer.parseInt(""+idProducto));
		status.setComplete();
		return "redirect:/productos/listarProductos.htm";
	}
	
	@RequestMapping(params = "cancelar", method = RequestMethod.POST)
	public String cancelar(
			@ModelAttribute("producto") Producto producto,
			BindingResult result, SessionStatus status) {
		return "redirect:/productos/listarProductos.htm";
	}
	
	@RequestMapping(params = "crear", method = RequestMethod.POST)
	public String crearProducto(
			@ModelAttribute("producto") Producto producto,
			BindingResult result, SessionStatus status) {
		try{
			productoValidator.validate(producto, result);
			if (result.hasErrors()) {
				return "detalleProducto";
			}
			producto.setPrecio(new BigDecimal(producto.getPrecioString()));
			productoBO.crearProducto(producto);
			status.setComplete();
			return "redirect:/productos/listarProductos.htm";
		}catch(Exception e){
			e.printStackTrace();
			return "detalleProducto";
		}
		
	}

}
