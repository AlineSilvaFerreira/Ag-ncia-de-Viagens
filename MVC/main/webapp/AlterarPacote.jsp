<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração do Pacote</title>

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
			<h5>Alteração do pacote</h5>

			<form action="alterarPacote" method="post" class="form-control">

				<input type="hidden" name="id" value="${pacote.id}">
				<fieldset>
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="valor" class="form-label">Valor: </label>
							<input type="text" class="form-control" name="valor" value="${pacote.valor}">
						</div>

						<div class="form-group col-4">
							<label for="desconto" class="form-label">Desconto:</label> 
							<input type="number" class="form-control" name="desconto" value="${pacote.desconto}">
						</div>
					</div>

						<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="idHospedagem" class="form-label">Id Hospedagem: </label>
							<input type="number" class="form-control" name="idHospedagem" value="${pacote.getHospedagem().id}">
						</div>

						<div class="form-group col-4">
							<label for="idVoo" class="form-label">Id Voo:</label> 
							<input type="number" class="form-control" name="idVoo" value="${pacote.getVoo().id}">
						</div>
					</div>
					<button type="submit" class="btn btn-success">Atualizar</button>
				</fieldset>
			</form>
		</div>

	</div>


</body>
</html>