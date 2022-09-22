<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
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

	<div class="container">
		<h3>Cadastro</h3>
		<form action="InserirCliente" method="post" class="form-control">
			<fieldset>
				<legend>Informe os dados </legend>
				<form class="row g-3">
				<div class="row">
					<div class="col-md-5">
						<label for="inputEmail4" class="form-label">Email</label> <input
							type="email" class="form-control" id="inputEmail4">
					</div>
					<div class="col-md-6">
						<label for="inputPassword4" class="form-label">Password</label> <input
							type="password" class="form-control" id="inputPassword4">
					</div>
					</div>
					<div class="col-12">
						<label for="inputAddress" class="form-label">Address</label> <input
							type="text" class="form-control" id="inputAddress"
							placeholder="1234 Main St">
					</div>
					<div class="col-12">
						<label for="inputAddress2" class="form-label">Address 2</label> <input
							type="text" class="form-control" id="inputAddress2"
							placeholder="Apartment, studio, or floor">
					</div>
					<div class="col-md-6">
						<label for="inputCity" class="form-label">City</label> <input
							type="text" class="form-control" id="inputCity">
					</div>
					<div class="col-md-4">
						<label for="inputState" class="form-label">State</label> <select
							id="inputState" class="form-select">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
					<div class="col-md-2">
						<label for="inputZip" class="form-label">Zip</label> <input
							type="text" class="form-control" id="inputZip">
					</div>
					<div class="col-12">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="gridCheck">
							<label class="form-check-label" for="gridCheck"> Check me
								out </label>
						</div>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">Sign in</button>
					</div>
				</form>
			</fieldset>
		</form>

		<br>
		<h5>Contatos cadastrado</h5>

		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Idade</th>
					<th>Data cadastro</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaContatos}" var="contato">
					<tr>
						<td>${contato.nome}</td>
						<td>${contato.idade}</td>
						<td>${contato.dataCadastro}</td>
						<td><a href="editar?id=${contato.id}" class="btn btn-success">Editar</a>
							<a href="excluir?id=${contato.id}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger">Excluir</a></td>
					</tr>
				</jstl:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>