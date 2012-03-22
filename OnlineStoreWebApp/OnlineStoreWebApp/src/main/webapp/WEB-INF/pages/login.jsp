<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/css/estilo.css"/>"
	type="text/css" />
<script type="text/javascript">
	function focus() {
		document.getElementById("j_username").focus();
	}
</script>
<title>Online Store</title>
</head>

<body onload="focus();">
	<div align="center">


		<table align="center">
			<tr>
				<td><img src="../images/cabeceraOnlineStore.png" /></td>
			</tr>


			<tr>
				<td>


					<form action="<c:url value='/j_spring_security_check'/>"
						method="post">
						<table border="1" cellspacing="2" cellpadding="2" align="center">
							<tr>

								<td>
									<table>
										<tr>
											<td colspan="2" align="center" class="tablaTitulo"><strong>Acceso</strong>
											</td>
										</tr>
										<tr>
											<td><div align="right">Usuario:</div></td>
											<td><input type="text" name="j_username"
												class="campoEditar" id="j_username" /></td>
										</tr>
										<tr>
											<td><div align="right">Contraseña:</div></td>
											<td><input type="password" name="j_password"
												class="campoEditar" /></td>
										</tr>
										<tr>
											<td colspan="2" align="center"><input class="boton"
												type="submit" value="Aceptar" /></td>
										</tr>
									</table>

								</td>
							</tr>

						</table>
						<div align="center" class="error">
						<br></br>
							<c:if test="${!empty param.loginError}">
								<spring:message code="login.invalid" />
							</c:if>
						</div>

					</form>

				</td>
			</tr>
		</table>






	</div>
</body>

</html>