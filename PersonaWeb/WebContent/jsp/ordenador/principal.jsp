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
<title><spring:message code="ordenador.titulo"/></title>
</head>
<body>
	<h1><spring:message code="ordenador.titulo"/></h1>
	
		<form:form action="agregar.do" commandName="ordenadorForm" method="POST">
		
		<form:errors path="*" cssStyle="border: 1px solid red; color: red"/>
		<table>
			<tr>
				<td><spring:message code="ordenador.nombre"/>:</td>
				<td><form:input path="nombre"/></td>
				<td><form:errors path="nombre" cssStyle="border: 1px solid red; color: red"/></td>
			</tr>
			<tr>
				<td><spring:message code="ordenador.serial"/>:</td>
				<td><form:input path="serial"/></td>
				<td><form:errors path="serial" cssStyle="border: 1px solid red; color: red"/></td>
			</tr>
			<tr>
				<td><spring:message code="ordenador.propietario"/>:</td>
				<td>
					<!-- form:select 
						path="personaId" 
						items="${personas}" 
						itemLabel="nombre" 
						itemValue="id"/-->

					<select name="personaId">					
						<c:forEach items="${personas}" var="p">
							<c:set var="selected" value=""/>
							<c:if test="${p.id == ordenadorForm.personaId}">
								<c:set var="selected" value="selected"/>
							</c:if>
						
							<option value="${p.id}" ${selected}>${p.nombre} ${p.apellido}</option>
						</c:forEach>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="<spring:message code="ordenador.boton.agregar"/>"/>
				</td>
			</tr>
		</table>
	</form:form>
			
	<br/>
	
	<table>
		<tr>
			<th><spring:message code="ordenador.nombre"/></th>
			<th><spring:message code="ordenador.serial"/></th>
			<th><spring:message code="ordenador.propietario"/></th>
		</tr>
		<c:forEach items="${ordenadores}" var="o">
			<c:set var="propietario" value="${o.persona.nombre} ${o.persona.apellido}"/>			
			<tr>
				<td>${o.nombre}</td>
				<td>${o.serial}</td>
				<td>${propietario}</td>
			</tr>
		</c:forEach>
			
	</table>
</body>
</html>