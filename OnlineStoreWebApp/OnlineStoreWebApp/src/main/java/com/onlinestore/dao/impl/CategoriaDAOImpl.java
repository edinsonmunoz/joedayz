package com.onlinestore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.onlinestore.dao.CategoriaDAO;
import com.onlinestore.model.Categoria;

@Repository("CategoriaDAO")
public class CategoriaDAOImpl extends SqlMapClientDaoSupport implements CategoriaDAO{
	
	@Autowired
	public CategoriaDAOImpl(SqlMapClient sqlMapClient) {
		super();
		super.setSqlMapClient(sqlMapClient);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategorias(){
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = getSqlMapClientTemplate().queryForList("Categoria.listarCategorias");
		return listaCategorias;
	}
	
}
