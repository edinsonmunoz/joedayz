<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/css/estilo.css"/>"
	type="text/css" />
<script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#page_effect').fadeIn(1000);

	});

	function contarCaracteres(t) {
		n = document.getElementById("txtDescripcion").value.length;
		if (n > t)
			document.getElementById("txtDescripcion").value = document
					.getElementById("txtDescripcion").value.substring(0, t);

	}
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
				<td><div align="right">
						<strong> <a href="../j_spring_security_logout">Cerrar
								Sesion</a> (<security:authentication property="principal.username" />)
						</strong>
					</div></td>
			</tr>
			<tr>
				<td><h2>Producto</h2></td>
			</tr>
			<tr>
				<td><form:form commandName="producto" name="menuForm">

						<div>

							<fieldset>
								<legend>
									<strong>Detalle de Producto</strong>
								</legend>
								<table>
									<tr>
										<td>Nombre:</td>
										<td><security:authorize ifAllGranted="ROLE_ADMIN">
												<form:input cssClass="campoEditar" path="nombre" size="50"
													maxlength="50" />
											</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">
												<form:input cssClass="campoEditar" path="nombre" size="50"
													maxlength="50" disabled="true" />
											</security:authorize></td>
										<td><form:errors cssClass="error" path="nombre" /></td>
									</tr>
									<tr>
										<td>Tipo:</td>
										<td><security:authorize ifAllGranted="ROLE_ADMIN">

												<form:select cssClass="combo" path="idCategoria"
													id="idCategoria">
													<!-- form:option value="0" label="-- Seleccione Categoria --" /-->
													<form:options items="${categorias}" itemValue="idCategoria"
														itemLabel="nombre" />
												</form:select>
											</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">

												<form:select cssClass="combo" path="idCategoria"
													disabled="true" id="idCategoria">
													<!-- form:option value="0" label="-- Seleccione Categoria --" /-->
													<form:options items="${categorias}" itemValue="idCategoria"
														itemLabel="nombre" />
												</form:select>
											</security:authorize></td>
										<td><form:errors cssClass="error" path="idCategoria" /></td>
									</tr>
									<tr>
										<td>Codigo:</td>
										<td><security:authorize ifAllGranted="ROLE_ADMIN">
												<form:input cssClass="campoEditar" path="codigo" size="50"
													maxlength="50" />
											</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">
												<form:input cssClass="campoEditar" path="codigo" size="50"
													maxlength="50" disabled="true" />
											</security:authorize></td>
										<td><form:errors cssClass="error" path="codigo" /></td>
									</tr>
									<tr>
										<td valign="top">Descripcion:</td>
										<td><security:authorize ifAllGranted="ROLE_ADMIN">
												<form:textarea cssClass="campoEditar" path="descripcion"
													id="txtDescripcion" cols="70" rows="5"
													onkeypress="return validarMaxCaracteres(this.value, 250);" />
											</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">
												<form:textarea cssClass="campoEditar" path="descripcion"
													id="txtDescripcion" cols="70" rows="5" disabled="true"
													onkeypress="return validarMaxCaracteres(this.value, 250);" />
											</security:authorize></td>
										<td></td>
									</tr>
									<tr>
										<td>Precio:</td>
										<td><security:authorize ifAllGranted="ROLE_ADMIN">
												<form:input cssClass="campoEditar" path="precioString"
													onkeypress="EvaluateText('%f', this);" maxlength="11"
													onblur="this.value = NumberFormat('10', this.value, '2', '.', '')"
													size="20" />
											</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">
												<form:input cssClass="campoEditar" path="precioString"
													onkeypress="EvaluateText('%f', this);" maxlength="11"
													onblur="this.value = NumberFormat('10', this.value, '2', '.', '')"
													size="20" disabled="true" />
											</security:authorize></td>
										<td><form:errors cssClass="error" path="precioString" /></td>
									</tr>

								</table>
							</fieldset>
							<table>
								<tr>
									<td colspan="2" align="left" valign="bottom"><security:authorize
											ifAllGranted="ROLE_ADMIN">
											<c:choose>
												<c:when test="${producto.nuevo}">
													<button type="submit" class="boton" name="crear"
														onclick="return confirm('Desea guardar los datos del producto?')">Guardar</button>
													<button type="submit" class="boton" name="cancelar">Cancelar</button>
												</c:when>
												<c:otherwise>
													<button type="submit" class="boton" name="editar"
														onclick="return confirm('Desea guardar los datos del producto?')">Guardar</button>
													<button type="submit" class="boton" name="eliminar"
														onclick="return confirm('Desea eliminar el producto: ${producto.nombre}?')">
														Eliminar</button>
													<button type="submit" class="boton" name="cancelar">Cancelar</button>
												</c:otherwise>
											</c:choose>
										</security:authorize> <security:authorize ifAllGranted="ROLE_MEMBER">
											<button type="submit" class="boton" name="cancelar">Cancelar</button>
										</security:authorize></td>
								</tr>
							</table>




						</div>

					</form:form></td>
			</tr>
		</table>



	</div>
</body>

</html>
