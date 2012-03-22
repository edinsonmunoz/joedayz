package com.onlinestore.controller.validator;

import org.springframework.validation.Errors;

import com.onlinestore.model.Usuario;

public class LoginValidator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}
	
	/**
	 * Resumen.
	 * Método que valida el ingreso de usuario y clave
	 * @author Edinson Muñoz
	 */
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		String nombre = usuario.getUsuario()!=null?usuario.getUsuario().trim():"";
		String contrasenia = usuario.getContrasenia()!=null?usuario.getContrasenia().trim():"";
		if (nombre.equals("")) {
			errors.rejectValue("usuario", "usuario.required", "obligatorio");
		}
		if(contrasenia.equals("")){
			errors.rejectValue("contrasenia", "contrasenia.required", "obligatorio");
		}
		
	}
	
}
