<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/css/estilo.css"/>"
	type="text/css" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#page_effect').fadeIn(1000);
	});
</script>
<title>Online Store</title>
</head>

<body>
	<div id="page_effect" style="display: none;">
		<table align="center">
			<tr>
				<td><img src="../images/cabeceraOnlineStore.png" /></td>
			</tr>
			<tr>
				<td>


					<table width="100%">
						<tr>
							<td>
								<div align="left">
									<strong><a href="listarOpciones.htm"> << Volver a Opciones </a></strong>

								</div>
							</td>
							<td>
								<div align="right">
									<strong> <a href="../j_spring_security_logout">Cerrar
											Sesion</a> (<security:authentication
											property="principal.username" />)
									</strong>
								</div>
							</td>
						</tr>
					</table>




				</td>
			</tr>
			<tr>
				<td>
					<h2>Lista de Productos</h2>
				</td>
			</tr>
			<tr>
				<td><security:authorize ifAllGranted="ROLE_ADMIN">
						<button class="boton"
							onclick="window.location='detalleProducto.htm'" name="nuevo">Agregar</button>
					</security:authorize> <br></br> <form:form method="post">
						<fieldset>
							<legend>
								<strong>Filtros de Busqueda</strong>
							</legend>
							<table>
								<tr>
									<td>Nombre:</td>
									<td><input name="nombre" id="nombre" class="campoEditar" /></td>
									<td><input class="boton" type="submit" value="Buscar" /></td>
									<td></td>
								</tr>
							</table>
						</fieldset>
						</br>
						<display:table uid="producto" name="productos" defaultsort="1"
							defaultorder="ascending" pagesize="10" requestURI=""
							export="true">

							<display:setProperty name="export.excel.filename" 
								value="listadoProductos.xls" />
							<display:setProperty name="export.xml.filename"
								value="listadoProductos.xml" />
							<display:setProperty name="export.csv.filename"
								value="listadoProductos.csv" />


							<display:column property="nombre" sortable="false" title="Nombre"
								href="detalleProducto.htm" style="width:500px" 
								headerClass="tablaTitulo" class="tablaDato" paramId="productoId"
								paramProperty="idProducto">
							</display:column>
							<display:column property="precio" sortable="false"
								title="Precio (S/.)" style="width:80px;text-align:right"
								headerClass="tablaTitulo" class="tablaDato" />
						</display:table>

					</form:form></td>
			</tr>
		</table>
	</div>
</body>

</html>
