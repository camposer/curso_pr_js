<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Persona" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Ordenador" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="persona.titulo" /></title>
</head>
<body>
	<h1><spring:message code="persona.titulo" /></h1>
	
	<form:form commandName="personaForm" action="agregar.do" method="post">
		<form:errors path="*" cssStyle="border: 1px solid red;"/>
		<table>
			<tr>
				<td><spring:message code="persona.nombre" />:</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td><spring:message code="persona.apellido" />:</td>
				<td><form:input path="apellido"/></td>
			</tr>
			<tr>
				<td><spring:message code="persona.fechaNacimiento" />:</td>
				<td><form:input path="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td><spring:message code="persona.altura" />:</td>
				<td><form:input path="altura"/></td>
			</tr>
			<tr>
				<td>
					<spring:message code="persona.ordenadores" />:<br/>
					<table>
						<tr>
							<td><spring:message code="ordenador.nombre" />:</td>
							<td><form:input path="ordenadorNombre"/></td>
						</tr>
						<tr>
							<td><spring:message code="ordenador.serial" />:</td>
							<td><form:input path="ordenadorSerial"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="<spring:message code="ordenador.boton.agregar" />"/></td>
			</tr>
		</table>
	</form:form>
	
	<br/>
	
	<table border="1">
		<tr>
			<th><spring:message code="persona.nombre" /></th>
			<th><spring:message code="persona.apellido" /></th>
			<th><spring:message code="persona.fechaNacimiento" /></th>
			<th><spring:message code="persona.altura" /></th>
			<th><spring:message code="persona.ordenadores" /></th>
		</tr>

	<c:forEach items="${personas}" var="p">
		<tr>
			<td>${p.nombre}</td>
			<td>${p.apellido}</td>
			<td><c:out value="${p.fechaNacimiento}" /></td>
			<td>${p.altura}</td>
			<td>
				<ul>
					<c:forEach items="${p.ordenadores}" var="o">
						<!-- >li><c:out value="${o.nombre} ${o.serial}"/></li-->
						<li>${o.nombre} ${o.serial}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>