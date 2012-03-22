package com.onlinestore.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.bo.CategoriaBO;
import com.onlinestore.dao.CategoriaDAO;
import com.onlinestore.model.Categoria;

@Service("CategoriaBO")
public class CategoriaBOImpl implements CategoriaBO{

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	public List<Categoria> listarCategorias(){
		return categoriaDAO.listarCategorias();
	}
	
}
