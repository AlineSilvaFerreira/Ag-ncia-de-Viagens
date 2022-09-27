<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração da hospedagem</title>
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
			<h5>Alteração da hospedagem</h5>

			<form action="alterarHospedagem" method="post" class="form-control">

				<input type="hidden" name="id" value="${hospedagem.id}">
				<fieldset>
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="diarias" class="form-label">Diarias: </label>
							<input type="number" class="form-control" name="diarias" value="${hospedagem.diarias}">
						</div>

						<div class="form-group col-4">
							<label for="incluso" class="form-label">Incluso:</label> 
							<input type="text" class="form-control" name="incluso" value="${hospedagem.incluso}">
						</div>
					</div>

					<button type="submit" class="btn btn-success">Atualizar</button>
				</fieldset>
			</form>
		</div>

	</div>

</body>
</html>