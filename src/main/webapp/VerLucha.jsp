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
	<div class="container mt-5">
	<h1 class="m-5"> LUCHA </h1>
	<p> Elige el primer caballero</p>
	<div class="row">
		<div class="col-3">
		</div>
			<ul class="list-group">
				<c:forEach items="${caballeros}" var="caballero" varStatus="loop">
					  <li class="list-group-item">
					    <input class="form-check-input me-1" type="radio" name="elegido" value="${caballero.id}" id="Radio${loop.index}" checked>
					    <label class="form-check-label" for="firstRadio"> id: ${caballero.id} nombre: ${caballero.nombre} fuerza: ${caballero.fuerza} experiencia: ${caballero.experiencia} nombre: ${caballero.arma_id.nombre} arma: ${caballero.arma_id.nombre} escudo: ${caballero.escudo_id.nombre}</label>
					  </li>
				  </c:forEach>
					<a href="LuchaCaballero2">
						<button class="btn btn-outline-success" type="submit" name="caballero1" value="elegido">ELEGIR</button>
					</a>
			</ul>
		<div class="col-3">
		</div>
	</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>