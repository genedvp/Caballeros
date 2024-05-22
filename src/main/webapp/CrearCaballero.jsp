<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Caballero</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="GuardarCaballero" method="post">
    <fieldset>
        <legend>Crear Caballero</legend>
        
        <div class="mb-3">
            <label class="form-label">Nombre</label>
            <input type="text" class="form-control" placeholder="Nombre Caballero" name="nombre" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Fuerza</label>
            <input type="number" class="form-control" placeholder="int" name="fuerza" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Arma</label>
            <select class="form-select" id="inputGroupSelect01" name="arma" required>
                <c:forEach items="${armas}" var="arma">
                    <option value="${arma.id}">${arma.nombre}</option>
                </c:forEach>
            </select>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Escudo</label>
            <select class="form-select" id="inputGroupSelect01" name="escudo" required>
                <c:forEach items="${escudos}" var="escudo">
                    <option value="${escudo.id}">${escudo.nombre}</option>
                </c:forEach>
            </select>
        </div>
        
        <button type="submit" value="Guardar" name="Guardar" class="btn btn-secondary">Guardar</button>
    </fieldset>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
