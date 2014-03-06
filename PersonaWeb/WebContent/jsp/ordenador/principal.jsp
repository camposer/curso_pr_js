<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.js.model.Persona" %>
<%@ page import="es.indra.formacion.pr.js.model.Ordenador" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<title><spring:message code="ordenador.titulo"/></title>
	<script>
		// TODO: Refactorizar este código con JSRender (deprecated: jQuery-template)
		var imprimirOrdenadores = function(ordenadores) {
			var serial = "<spring:message code="ordenador.serial"/>";
			var html = 
			"	<table>" +
			"		<tr>" +
			'			<th><spring:message code="ordenador.nombre"/></th>' +
			"			<th>" + serial + "</th>" +
			"			<th><spring:message code="ordenador.propietario"/></th>" +
			"		</tr>";
			
			$(ordenadores).each(function(idx, o){
				//var propietario = o.persona.nombre + " " + o.persona.apellido;
				var propietario = ordenadores[idx].persona.nombre + " " + o.persona.apellido;
				html += 
					"<tr>" +
					"	<td>" + o.nombre + "</td>" +
					"	<td>" + o.serial + "</td>" +
					"	<td>" + propietario + "</td>" +
					"</tr>";
			});			
			
			html += "</table>";
			
			$("#contenido").html(html);
		};
		
		var imprimirPersonas = function(personas) {
			var selectedId = "<c:out value="${ordenadorForm.personaId}"/>";
			
			var select = $("<select name='personaId'>");
			
			for (var i in personas) {
				var p = personas[i];
				var option = $("<option>"); // => document.createElement("option");
				option.attr("value", p.id);
				option.html(p.nombre + " " + p.apellido);

				if (selectedId != "" && selectedId == p.id)
					option.attr("selected", "selected");	

				option.appendTo(select);
			}
			
			$("#divPersonaId").html("");
			select.appendTo("#divPersonaId");
		};
		
		var peticionOrdenadores = function() {
			var url = "/PersonaWeb/rest/ordenadores";
			
			var ajax = $.ajax(url, {
				type: "GET",
				dataType: "json"
			}).done(imprimirOrdenadores).fail(function() {
				window.alert("Error getting data");
			});
			
		};
		
		var peticionPersonas = function() {
			var url = "/PersonaWeb/rest/personas";
			
			var ajax = $.ajax(url, {
				type: "GET",
				dataType: "json"
			}).done(imprimirPersonas).fail(function() {
				window.alert("Error getting data");
			});			
		};
	
		$(document).ready(function() {
			peticionOrdenadores();
			peticionPersonas();
			//<%= "var hola = ['uno', 'dos', 'tres']; " +
			"for (var i in hola) { " +
			"	window.alert(hola[i]);" + 
			"}" %>
		});
	</script>
</head>
<body>
<c:out value=""></c:out>
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
					<div id="divPersonaId">
					
					</div>
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
	
	<div id="contenido">
		<img src="../img/loading.gif" width="100" height="100"/>	
	</div>


</body>
</html>