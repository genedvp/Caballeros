<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Caballeros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
		<table class="table">
			  <thead>
			    <tr class="table-active">
			      <th scope="col">id</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Fuerza</th>
			      <th scope="col">Experiencia</th>
			      <th scope="col">Arma</th>
			      <th scope="col">Escudo</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${caballeros}" var="caballero">
					<tr>
						<td>${caballero.id}</td>
						<td>${caballero.nombre}</td>
						<td>${caballero.fuerza}</td>
						<td>${caballero.experiencia}</td>
						<td>${caballero.arma_id.nombre}</td>
						<td>${caballero.escudo_id.nombre}</td>
					</tr>
				</c:forEach>
			 </tbody>
		</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>