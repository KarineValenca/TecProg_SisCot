<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>SisCot</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="blue lighten-5	">
	<c:import url="header.jsp" />
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center orange-text">Sistema de Cotações</h1>
			<div class="row center">
				<h5 class="header col s12 light">Sistema Ágil de Cotações para
					Compra de Produtos de Fornecedores</h5>
			</div>
			<div class="row center">

				<%
					if (session.getAttribute("user") == null) {
				%>

				<a href="/SisCot/login.jsp" id="download-button"
					class="btn-large waves-effect waves-light orange">Fazer Login</a>
				<%
					}
				%>
			</div>
			<br> <br>

		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">flash_on</i>
						</h2>
						<h5 class="center">Agilidade de Negociações</h5>

						<p class="light">Nós desenvolvemos um sistema capaz de
							possibilitar que qualquer fornecedor dê seus preços a cada
							cotação. De qualquer lugar do mundo o fornecedor pode visualizar
							a cotação que está sendo executada, visualizar os produtos
							solicitados e dar todos os seus preços.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">Aumente a sua competitividade</h5>

						<p class="light">Utilizando sistema de cotações, sua
							organização pode acompanhar os menores preços de cada produto e
							assim ofertar um preço melhor a fim de ganhar a cotação naquele
							produto.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">settings</i>
						</h2>
						<h5 class="center">Facilidade de Acesso</h5>

						<p class="light">Nós Desenvolvemos um sistema de acesso fácil
							e intuitivo, melhorando a sua sensação de navegabilidade e
							facilitando a busca por informações. É extremamente simples
							participar de uma cotação e dar o seu melhor preço. Faça parte
							desse círculo de fornecedores Ágeis e competitivos.</p>
					</div>
				</div>
			</div>

		</div>
		<br> <br>

		<div class="section"></div>
	</div>

	<footer class="page-footer orange">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">BMGWA Developers</h5>
				<p class="grey-text text-lighten-4">Somos um time de
					Desenvilvimento de Software, estudantes da Universidade de Brasília
					Unidade Gama - UnB FGA. Desenvolvemos aplicações e sistemas de
					acordo com a necessidade do cliente, sempre com o objetivo de
					satisfazê-lo.</p>


			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Configurações</h5>
				<ul>
					<li><a class="white-text"
						href="https://github.com/BMGWA/SisCot">Código da Aplicação</a></li>
					<li><a class="white-text"
						href="https://github.com/BMGWA/SisCot/wiki">Documentação</a></li>
				</ul>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Contato</h5>
				<ul>
					<li><a class="white-text" href="#!">Iago Rodrigues</a></li>
					<li><a class="white-text" href="#!">Jonathan Rufino</a></li>
					<li><a class="white-text" href="#!">Tiago Assunção</a></li>
				</ul>

			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			Made by <a class="orange-text text-lighten-3"
				href="http://materializecss.com">Materialize</a>
		</div>
	</div>
	</footer>


	<!-- jQuery Library -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>
