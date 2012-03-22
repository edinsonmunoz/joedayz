package com.onlinestore.model;

import java.math.BigDecimal;

public class Producto {

	private long idProducto;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private String codigo;
	private int idCategoria;
	private boolean nuevo;
	private String precioString;
	
	public Producto() {
		super();
	}

	public Producto(long idProducto, String nombre, String descripcion,
			BigDecimal precio, String codigo, int idCategoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
		this.idCategoria = idCategoria;
	}
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isNuevo() {
		return nuevo;
	}
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	public String getPrecioString() {
		return precioString;
	}
	public void setPrecioString(String precioString) {
		this.precioString = precioString;
	}
	
	
	
	
	
	
}
