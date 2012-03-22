package com.onlinestore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinestore.controller.validator.LoginValidator;
import com.onlinestore.model.Usuario;

/**
 * Controller para manejar el formulario del login
 */
@Controller
@RequestMapping("/login.htm")
@SessionAttributes("login")
public class LoginController {

	private LoginValidator loginValidator;
	
	public LoginController() {
		loginValidator = new LoginValidator();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView verDetalleProducto(HttpServletRequest request)
			throws ServletRequestBindingException {
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", new Usuario());
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute("login") Usuario usuario,
			BindingResult result, SessionStatus status) {
		loginValidator.validate(usuario, result);
		if (result.hasErrors()) {
			return "login";
		}
		status.setComplete();
		//System.out.println("LOGIN....");
		return "redirect:/productos/listarOpciones.htm";
	}

	

}
