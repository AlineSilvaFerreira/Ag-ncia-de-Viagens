<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospedagem</title>
<link href="Paginas/home.css" rel="stylesheet">
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

	<!-- Inicio do Navbar -->
	<nav
		class="navbar bg-white navbar-expand-lg navbar-light border-bottom fixed-top">
		<div class="container-fluid ">
			<a href="Paginas/index.html"> <img class="logo"
				src="imgs/logomarca.png"></a>

			<div class="dropstart">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button-secondary" data-bs-toggle="dropdown"
					aria-expanded="false">
					<button class="btn btn-light" type="button">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                    <path
								d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" /> </svg>
					</button>
				</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="Paginas/login.html">Login</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="">Administrador</a></li>
				</ul>
			</div>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>

	<div class="espaco"></div>
	<!-- Fim do navbar -->

	
	<div class="main">	
	
	<div class="row d-flex justify-content-center mb-4">
		<div class="col-12 ">
			<ul class="nav d-flex justify-content-end">									
				<li class="nav-link mx-1"><a href="MenuAdm.html"> <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="currentColor" class="bi bi-house" viewBox="0 0 16 16"> <path fill-rule="evenodd"
					d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
  					<path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" />
					</svg></a>
				</li>
				<li class="nav-link mx-3"><a href="Paginas/login.html"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">	<path
					d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
  					<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
					</svg></a>
				</li>
			</ul>
		</div>
	</div>
		
		<h3 class="text-center mb-4">Hospedagens</h3>
		
		<!-- Início formulário cadastro -->
		<div class="container d-flex justify-content-center flex-wrap">
			<form action="InserirHospedagem" method="post"
				class="form-control p-3" style="width: 600px;">

				<fieldset>
					<legend>Informe os dados </legend>
					<div class="row g-3 ">
						<div class="form-group mb-3 col-6">
							<label for="diarias" class="form-label">Diarias:</label> <input
								name="diarias" type="number" class="form-control" id="diarias">
						</div>

						<div class="form-group col-6">
							<label for="incluso" class="form-label">Incluso:</label> <input
								name="incluso" type="text" class="form-control" id="incluso">
						</div>
					</div>

					<div class="col-12">
						<button type="submit" class="btn btn-outline-secondary">Cadastrar</button>
					</div>
				</fieldset>
			</form>
		</div>
		<!-- Fim formulário cadastro -->

		<!-- Início tabela mostrar -->
		<div class="container mt-5 mb-5" style="width: 700px">

			<h4 class="mb-2 text-center">Hospedagens cadastradas</h4>
			<div class="table-responsive-md">
				<table class="mt-3 table table-bordered align-middle text-center">
					<thead class="table-light">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Diárias</th>
							<th scope="col">Incluso</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>

					<tbody>
						<jstl:forEach items="${listaHospedagem}" var="hospedagem">
							<tr>
								<td>${hospedagem.id}</td>
								<td>${hospedagem.diarias}</td>
								<td>${hospedagem.incluso}</td>

								<td class="p-2"><a href="alterarHospedagem?id=${hospedagem.id}"
									class="btn btn-outline-info me-2">Editar</a> <a
									href="excluirHospedagem?id=${hospedagem.id}"
									onclick="return confirm('Deseja Excluir?')"
									class="btn btn-outline-danger">Excluir</a></td>
							</tr>
						</jstl:forEach>

					</tbody>
				</table>
			</div>
		</div>		
		<!-- Fim tabela mostrar -->
		
	</div>
</body>
</html>