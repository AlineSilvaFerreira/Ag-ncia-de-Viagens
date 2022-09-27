<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração do contato ${voo.origem} X ${voo.destino}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="main">
		<div class="container">
			<h5>Alteração do voo ${voo.origem} X ${voo.destino}</h5>

			<form action="alterarVoo" method="post" class="form-control">

				<input type="hidden" name="id" value="${voo.id}">
				<fieldset>
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="origem" class="form-label">Origem: </label>
							<input type="text" class="form-control" name="origem" value="${voo.origem}">
						</div>

						<div class="form-group col-4">
							<label for="destino" class="form-label">Destino:</label> 
							<input type="text" class="form-control" name="destino" value="${voo.destino}">
						</div>
					</div>

					<div class="row">
						<div class="form-group mb-3 col-6">
							<label for="dataIda" class="form-label">Data ida: </label>
							<input type="text"  class="form-control" name="dataIda" value="${voo.dataIda}">
						</div>
					
						<div class="form-group mb-3 col-6">
							<label for="dataVolta" class="form-label">Data volta:</label>
							<input type="text"  class="form-control" name="dataVolta" value="${voo.dataVolta}">
						</div>
						
						<div class="form-group mb-3 col-6">
							<label for="valor" class="form-label">Valor: </label>
							<input type="text"  class="form-control" name="valor" value="${voo.valor}">
						</div>
						
					
					</div>
					<button type="submit" class="btn btn-success">Atualizar</button>
				</fieldset>
			</form>
		</div>

	</div>
</body>
</html>