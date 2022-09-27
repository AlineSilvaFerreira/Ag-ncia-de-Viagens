<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Hospedagem" import="model.Voo"
	import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!doctype html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Pacote</title>
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
	
	<!-- Inicio formulário cadastro -->
		<h3 class="text-center mb-4">Cadastro de Pacote</h3>
		
		<div class="container d-flex justify-content-center flex-wrap">			
			<form action="InserirPacote" method="post" class="form-control p-3"	style="width: 600px;">

				<fieldset>
					<legend>Dados Pacote</legend>
					<div class="row g-3">
						<div class="form-group mb-3 col-6">
							<label for="valor" class="form-label">Valor:</label> <input
								name="valor" type="text" class="form-control" id="valor">
						</div>

						<div class="form-group col-6">
							<label for="desconto" class="form-label">Desconto:</label> <input
								name="desconto" type="number" class="form-control" id="desconto">
						</div>
					</div>

					<div class="row">
						<div class="form-group mb-3 col-6">
							<label for="idHospedagem" class="form-label">Id	Hospedagem: </label> 
							<input name="idHospedagem" type="number" class="form-control" id="idHospedagem">
						</div>

						<div class="form-group mb-3 col-6">
							<label for="idVoo" class="form-label">Id Voo:</label> <input
								name="idVoo" type="text" class="form-control" id="idVoo">
						</div>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-outline-secondary">Cadastrar</button>
					</div>
				</fieldset>
			</form>
			<!-- Fim formulário cadastro -->
			 	
		
			<a href="ListarVoo"><button type="submit" class="btn btn-outline-secondary m-4">Voos</button> </a>
			  <a href="ListarHospedagem"><button type="submit" class="btn btn-outline-secondary m-4">Hospedagens</button> </a>
				
				<!-- inicio tabela mostrar -->
				<div class="container mt-5 mb-5" >
				
				<h4 class="mb-2 text-center">Pacotes cadastrados</h4>
				<div class="table-responsive">
					<table class="mt-3 table table-bordered align-middle text-center">
						<thead class="table-light">
							<tr>
								<th scope="col">Destino</th>
								<th scope="col">Data Ida</th>								
								<th scope="col">Diárias</th>
								<th scope="col">Incluso</th>
								<th scope="col">Valor</th>
								<th scope="col">Desconto</th>
								<th scope="col">Valor Total</th>
								<th scope="col">Ações</th>
							</tr>
						</thead>

						<tbody>
							<jstl:forEach items="${listaPacote}" var="pacote">
								<tr>
									<td>${pacote.getVoo().destino}</td>
									<td>${pacote.getVoo().dataIda}</td>
									<td>${pacote.getHospedagem().diarias}</td>
									<td>${pacote.getHospedagem().incluso}</td>
									<td>${pacote.valor}</td>
									<td>${pacote.desconto}</td>
									<td>${pacote.calcularPromocao()}</td>

									<td class="p-2"><a href="alterarPacote?id=${pacote.id}"
										class="btn btn-outline-info me-2">Editar</a> <a
										href="excluirPacote?id=${pacote.id}"
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
	</div>

</body>
</html>