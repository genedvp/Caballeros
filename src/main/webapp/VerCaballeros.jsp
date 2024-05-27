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
	<c:if test="${msg=='valido'}">
		<div class="alert alert-primary" role="alert">
	  		Validación completada
		</div>
	</c:if>
	<c:if test="${msg=='noValido'}">
		<div class="alert alert-danger" role="alert">
	  		No se ha podido realizar la validación correctamente
		</div>
	</c:if>
	<div class="container mt-5">
	<h1 class="m-5"> Caballeros </h1>
		<div class="row">
		<div class="col">
			<a href="CrearCaballero">
				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
		  			<path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
		 			<path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
				</svg>
			</a>
		</div>
		<div class="col">
			<form class="d-flex" role="search" method="POST" action="VerCaballeros">
	        	<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="stringDesconocido">
	        	<button class="btn btn-outline-success" type="submit" name="buscar">Buscar</button>
	      	</form>
		</div>
		</div>
		<div class="row">
		<div class="col-3">
		</div>
		<table class="table col-6">
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
		<div class="col-3">
		</div>
		</div>
		<div class="row">
		<a href="LuchaCaballero1">
				<button class="btn btn-outline-success" type="submit" name="pelea">PELEAR</button>

		</a>
	</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>