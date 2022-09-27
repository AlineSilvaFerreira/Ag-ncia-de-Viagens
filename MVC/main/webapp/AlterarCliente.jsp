<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração do contato ${cliente.nome}</title>

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
			<h5>Alteração do cliente ${cliente.nome}</h5>

			<form action="alterar" method="post" class="form-control">

				<input type="hidden" name="id" value="${cliente.id}">
				<fieldset>
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="nome" class="form-label">Nome: </label>
							<input type="text" class="form-control" name="nome"	value="${cliente.nome}">
						</div>

						<div class="form-group col-4">
							<label for="telefone" class="form-label">Telefone:</label> 
							<input type="text" class="form-control" name="telefone" value="${cliente.telefone}">
						</div>
					</div>

					<div class="row">
						<div class="form-group mb-3 col-6">
							<label for="cpf" class="form-label">CPF: </label>
							<input type="text"  class="form-control" name="cpf" value="${cliente.cpf}">
						</div>
					
					</div>
										
					<div class="row">
						<div class="form-group mb-3 col-6">
							<label for="estado" class="form-label">Estado: </label>
							<input type="text"  class="form-control" name="estado" value="${cliente.estado}">
						</div>
						<div class="form-group mb-3 col-6">
							<label for="cidade" class="form-label">Cidade: </label>
						<input type="text" class="form-control" name="cidade" value="${cliente.cidade}">
						</div>
					</div>
					
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="rua" class="form-label">Rua: </label>					
							<input type="text" class="form-control" name="rua" value="${cliente.rua}">
						</div>
						<div class="form-group mb-3 col-4">
							<label for="numero" class="form-label">Número: </label>
						<input type="number" class="form-control" name="numero" value="${cliente.numero}">
						</div>
					</div>
					<div class="row">
						<div class="form-group mb-3 col-8">
							<label for="bairro" class="form-label">Bairro: </label>					
							<input type="text" class="form-control" name="bairro" value="${cliente.bairro}">
						</div>
						<div class="form-group mb-3 col-4">
							<label for="cep" class="form-label">CEP: </label>
							<input type="text" class="form-control"  name="cep" value="${cliente.cep}">
						</div>
					</div>
					<button type="submit" class="btn btn-success">Atualizar</button>
				</fieldset>
			</form>
		</div>

	</div>
</body>
</html>