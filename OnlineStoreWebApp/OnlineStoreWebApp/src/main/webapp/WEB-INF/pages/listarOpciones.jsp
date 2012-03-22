<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/css/estilo.css"/>"
	type="text/css" />
<title>Online Store</title>
</head>

<body>
	<div>


		<table align="center">
			<tr>
				<td><img src="../images/cabeceraOnlineStore.png" /></td>
			</tr>
			<tr>
				<td><div align="right">
						<strong> <a href="../j_spring_security_logout">Cerrar
								Sesion</a> (<security:authentication property="principal.username" />)
						</strong>
					</div></td>
			</tr>
			<tr>
				<td><h2>Opciones</h2></td>
			</tr>
			<tr>
				<td><p>
						<a href="listarProductos.htm">Lista de Productos</a>
					</p></</td>
			</tr>


		</table>




	</div>
</body>

</html>