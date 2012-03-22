package com.onlinestore.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlinestore.model.Usuario;

/**
 * 
 */
@Controller
@RequestMapping("/listarOpciones.htm")
public class OpcionesController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarOpciones(HttpServletRequest request)
			throws ServletRequestBindingException {
		//System.out.println("LISTAR");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listarOpciones");
		mav.addObject("opciones", new Usuario());
		return mav;
	}

	

}
