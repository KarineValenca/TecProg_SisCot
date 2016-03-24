# SisCot - Sistema de Cotações
Repositório oficial https://github.com/BMGWA/SisCot

## Sistema Ágil de Cotações para Compra de Produtos de Fornecedores

### Agilidade de Negociações
Nós desenvolvemos um sistema capaz de possibilitar que qualquer fornecedor dê seus preços a cada cotação. De qualquer lugar do mundo o fornecedor pode visualizar a cotação que está sendo executada, visualizar os produtos solicitados e dar todos os seus preços.

### Aumente a sua competitividade
Utilizando sistema de cotações, sua organização pode acompanhar os menores preços de cada produto e assim ofertar um preço melhor a fim de ganhar a cotação naquele produto.

### Facilidade de Acesso
Nós Desenvolvemos um sistema de acesso fácil e intuitivo, melhorando a sua sensação de navegabilidade e facilitando a busca por informações. É extremamente simples participar de uma cotação e dar o seu melhor preço. Faça parte desse círculo de fornecedores Ágeis e competitivos.

## Guia de Instalação
A aplicação SisCot foi desenvolvida primordialmente na linguagem Java 8, além de utilizar algumas ferramentas para apoiar o desenvolvimento. Neste software foram utilizadas as seguintes tecnologias e ferramentas:

* JRE 1.8
* JDK 1.8
* Eclipse 4.5.0
* Apache Tomcat 7.0.64
* Mysql 5.5
* OS Linux
* JUnit 4.10
* Eclemma
* Materialize 0.97.1
* JQuery 2.1.1
* JSTL core

Para a utilização da aplicação, apenas algumas dessas ferramentas necessitam de instalação, as demais já são implantadas dentro do código.

### JDK
Primeiramente será feita a instalação do JDK.
<br>
`sudo apt-get install python-software-properties` <br>
`sudo add-apt-repository ppa:webupd8team/java` <br>
`sudo apt-get update`<br>
`sudo apt-get install oracle-java8-installer`<br>

### JRE
Pronto, agora vamos ao jre.
<br><br>
`su -`<br>
`echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu precise main" | tee  /etc/apt/sources.list.d/webupd8team-java.list`<br>
`echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu precise main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list`<br>
`apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886`<br>
`apt-get update`<br>
`apt-get install oracle-java7-installer`<br>
`exit`<br>

### MySQL
O ambiente Java está pronto. Agora adicionaremos o banco de dados.

1&deg; passo:
<br/><br/>
<strong>`nano /etc/apt/sources.list`</strong>
<br/><br/>
<div class="codigo">
`deb http://ftp.br.debian.org/debian stable main`<br/>
`deb-src http://ftp.br.debian.org/debian stable main`
</div><br/>
Salvar o arquivo: Ctrl+c S
<br/><br/>
2&deg; passo:
<br/><br/>
<strong> `apt-get update`<br/>
`aptitude install mysql-server mysql-client`</strong>
<br/><br/>
Será instalada a versão 5.0 do MySQL.
<br/><br/>
3&deg; passo:
<br/><br/>
<strong> `nano /etc/apt/sources.list`</strong>
<br/><br/>
<div class="codigo">
<span class="comentario">`deb http://ftp.br.debian.org/debian stable main`</span><br/>
<span class="comentario">`deb-src http://ftp.br.debian.org/debian stable main`</span><br/>
`deb http://packages.dotdeb.org lenny all`
</div><br/>
Salvar o arquivo e em seguida:
<br/><br/>
<strong> `apt-get remove mysql-server-5.0`<br/>
 `apt-get remove mysql-client-5.0`<br/>
<br/>
 `apt-get update`<br/>
 `apt-get install mysql-server-5.1`<br/>
 `apt-get install mysql-client-5.1`</strong>
<br/><br/>

Acesse o mysql console utilizando os comandos e sua respectiva senha:

`mysql -u root -p`

Crie uma nova base de dados com o nome SisCot: 

`CREATE DATABASE biblioteca;`

Crie os usuários com os seguintes nomes e senhas:

`CREATE USER 'siscot'@'localhost' IDENTIFIED BY '12345';`

`GRANT ALL PRIVILEGES ON * . * TO 'siscot'@'localhost';`

`FLUSH PRIVILEGES;`

Agora adentre na pasta do SisCot/src/resouces e execute o arquivo siscot.sql com o MySql instalado.
Dessa maneira sua base de dados estará configurada para persistir os dados da aplicação.

### Apache Tomcat
 <p>Baixe o Tomcat 7 em <code><a href="http://tomcat.apache.org/" rel=nofollow>http://tomcat.apache.org/</a></code> na página de downloads da versão que escolher, você precisa de uma "Binary Distribution". Mesmo no windows, dê preferência a versão <strong>.zip</strong>, para você entender melhor o processo de inicialização do servidor. A versão executável é apenas um <em>wrapper</em> para executar a JVM, já que o Tomcat é 100% Java.</p> <p>O Tomcat foi por muito tempo considerado implementação padrão e referência das novas versões da API de servlets. Ele também é o servlet container padrão utilizado pelo JBoss. Ele continua em primeira posição no mercado, mas hoje tem esse lugar disputado pelo Jetty e pelo Grizzly (esse último é o servlet container que faz parte do servidor de aplicação da Oracle/Sun, o Glassfish).</p> <p>Entre no diretório de instalação e execute o script <code>startup.sh</code>:</p> <pre><div class="highlight"><pre>cd apache-tomcat&lt;TAB&gt;/bin
./startup.sh
</pre></div></pre> 

Desta forma o servidor estará iniciado na porta 8080 do endereço de IP utilizado

## BMGWA Developers
Somos um time de Desenvilvimento de Software, estudantes da Universidade de Brasília Unidade Gama - UnB FGA. Desenvolvemos aplicações e sistemas de acordo com a necessidade do cliente, sempre com o objetivo de satisfazê-lo.

### Contato
| Integrante | Usuário Git | Email para Contato |
| --- | --- |---|
| Iago Rodrigues | [@Makrau](https://github.com/Makrau) | iago006@hotmail.com |
| Tiago Assunção | [@TiagoAssuncao](https://github.com/TiagoAssuncao) | tiago@sof2u.com|
