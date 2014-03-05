<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	List<String> resultados = new ArrayList();
	resultados.add("a");
	resultados.add("b");
	resultados.add("c");
%>
Estos son los resultados del partido de ayer (desde resultado.jsp):
<ul>
<%
	for (String r : resultados) {
%>
	<li><%= r %></li>
<%
	}
%>
</ul>