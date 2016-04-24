<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1.0" />
		<title>Cadastrar Fornecedor</title>
		<!-- CSS  -->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
			rel="stylesheet">
		<link href="css/materialize.css" type="text/css" rel="stylesheet"
			media="screen,projection" />
		<link href="css/style.css" type="text/css" rel="stylesheet"
			media="screen,projection" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body class="blue lighten-5">
		<c:import url="header.jsp" />
		<div class="row center">
			<h1>Cadastro de Fornecedores</h1>
		</div>
		<div class="container">
			<form class="pure-form pure-form-aligned" action="IncludeProvider"
				method="POST" class="center">
				<fieldset>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="cnpj">CNPJ</label> <input id="cnpj" name="cnpj"
								type="text" placeholder="Informe o cnpj">
						</div>
						<div class="pure-control-group col s6">
							<label for="phone">Telefone</label> <input id="phone" name="phone"
								type="text" placeholder="Informe o telefone">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="name">Nome</label> <input id="name" name="name"
								type="text" placeholder="Informe o nome">
						</div>
						<div class="pure-control-group col s6">
							<label for="adress">Endereço</label> <input id="adress"
								name="adress" type="text" placeholder="Informe o endereço">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="email">Email</label> <input id="email" name="email"
								type="text" placeholder="Informe o email">
						</div>
						<div class="pure-control-group col s6">
							<label for="city">Cidade</label> <input id="city" name="city"
								type="text" placeholder="Informe a cidade">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="password">Senha</label> <input id="password"
								name="password" type="text" placeholder="Informe a senha">
						</div>
						<div class="pure-control-group col s6">
							<label for="state">Estado</label> <input id="state" name="state"
								type="text" placeholder="Informe o estado">
						</div>
					</div>
					<div class="row">
						<div class="pure-control-group col s6">
							<label for="ddd">DDD</label> <input id="ddd" name="ddd"
								type="text" placeholder="Informe o ddd">
						</div>
						<div class="pure-control-group col s6">
							<label for="zip">CEP</label> <input id="zip" name="zip"
								type="text" placeholder="Informe o CEP">
						</div>
					</div>
					<div class="center">
						<button class="btn waves-effect waves-light" type="submit"
							name="action">Cadastrar</button>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>