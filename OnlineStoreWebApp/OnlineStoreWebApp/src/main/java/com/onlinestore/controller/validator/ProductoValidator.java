package com.onlinestore.controller.validator;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onlinestore.bo.ProductoBO;
import com.onlinestore.model.Producto;

/**
 * Instance validator for the {@link Producto} class. 
 */
public class ProductoValidator implements Validator {
	
	private ProductoBO productoBO;

	public ProductoValidator(ProductoBO productoBO) {
		this.productoBO = productoBO;
	}

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return Producto.class.isAssignableFrom(clazz);
	}

	/**
	 * Resumen.
	 * Método que valida el formulario de registro de productos
	 * @author Edinson Muñoz
	 */
	public void validate(Object target, Errors errors) {
		Producto producto = (Producto) target;
		int idProducto = Integer.parseInt(producto.getIdProducto()+"");
		String nombre = producto.getNombre()!=null?producto.getNombre().trim():"";
		String codigo = producto.getCodigo()!=null?producto.getCodigo():"";
		String precio = producto.getPrecioString()!=null? producto.getPrecioString():"";
		if (nombre.equals("")) {
			errors.rejectValue("nombre", "nombre.required", "obligatorio");
		}else if(productoBO.existeProducto(idProducto, nombre)){
			errors.rejectValue("nombre", "nombre.existe", "obligatorio");
		}
		/*if (tipo.equals("0")) {
			errors.rejectValue("idCategoria", "tipo.required", "obligatorio");
		}*/
		if (codigo.equals("")) {
			errors.rejectValue("codigo", "codigo.required", "obligatorio");
		}
		if (precio.equals("")) {
			errors.rejectValue("precioString", "precio.required", "obligatorio");
		}else if(!precio.matches("([0-9]{1,8})([.][0-9][0-9]){0,1}")){
			errors.rejectValue("precioString", "precio.formato", "obligatorio");
		}
		else if((new BigDecimal(precio)).longValue()<=0.00){
			errors.rejectValue("precioString", "precio.negativo", "obligatorio");
		}
	}

}
