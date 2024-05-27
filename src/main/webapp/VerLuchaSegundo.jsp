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
        <h1 class="m-5">LUCHA</h1>
        <p>Elige el segundo caballero</p>
        <form action="LuchaCaballeros" method="post">
            <ul class="list-group">
            	<input type="hidden" name="idPrimero" value="${idPrimero}">
                <c:forEach items="${caballeros}" var="caballero" varStatus="loop">
                    <li class="list-group-item mb-3">
                        <input class="form-check-input me-1" type="radio" name="idSegundo" value="${caballero.id}" id="Radio${loop.index}" checked>
                        <label class="form-check-label">id: ${caballero.id} nombre: ${caballero.nombre} fuerza: ${caballero.fuerza} experiencia: ${caballero.experiencia} nombre: ${caballero.arma_id.nombre} arma: ${caballero.arma_id.nombre} escudo: ${caballero.escudo_id.nombre}</label>
                    </li>
                </c:forEach>
                <button class="btn btn-outline-success" type="submit">ELEGIR</button>
            </ul>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
