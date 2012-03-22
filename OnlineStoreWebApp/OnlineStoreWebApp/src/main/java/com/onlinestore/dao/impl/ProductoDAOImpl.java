package com.onlinestore.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.onlinestore.dao.ProductoDAO;
import com.onlinestore.model.Producto;

@Repository("ProductoDAO")
public class ProductoDAOImpl extends SqlMapClientDaoSupport implements ProductoDAO  {
	
	@Autowired
	public ProductoDAOImpl(SqlMapClient sqlMapClient) {
		super();
		super.setSqlMapClient(sqlMapClient);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Producto> listarProductos(String nombre){
		List<Producto> listaProductos = new ArrayList<Producto>();
		Map map = new HashMap();
		map.put("nombre", "%"+nombre+"%");
		listaProductos = getSqlMapClientTemplate().queryForList("Producto.listarProductos", map);
		return listaProductos;
	}
	
	public Producto obtenerProducto(int idProducto) {
        Producto producto = (Producto)getSqlMapClientTemplate().queryForObject("Producto.obtenerProducto", idProducto);
        return producto;
    }
	
	public void editarProducto(Producto producto){
		getSqlMapClientTemplate().update("Producto.editarProducto", producto);
    }
	
	public void eliminarProducto(int idProducto){
		getSqlMapClientTemplate().delete("Producto.eliminarProducto", idProducto);
    }
	
	public void crearProducto(Producto producto){
		getSqlMapClientTemplate().insert("Producto.crearProducto", producto);
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean existeProducto(int idProducto, String nombre) {
        boolean retorno = false;
        Map map = new HashMap();
        map.put("nombre", nombre);
        map.put("idProducto", null);
        if(idProducto>0)
        	map.put("idProducto", idProducto);
        Integer valor = (Integer)getSqlMapClientTemplate().queryForObject("Producto.existeProducto", map);
        if (valor.intValue() >= 1)
            retorno = true;
        return retorno;
    }

}
