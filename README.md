![imagem local](/imagens_readme/logo.png)



# Docker

  - [Tecnologias Usadas](#Tecnologias-Usadas)
  - [Sobre](#Sobre)
  - [Inicio](#Inicio)
  - [Utilizando o Beekeeper](#Utilizando-o-Beekeeper)
  - [Comandos Básicos do Docker](#Comandos-Docker)
  - [Adicioando Java](#Adicioando-Java)
  - [Criando nossa Imagem e Container Docker](#Criando-Imagem-e-Container)
  


## Tecnologias Usadas

[Java](https://www.java.com/pt-BR/) / [Docker](https://www.docker.com/) / [MySQL](https://www.mysql.com/) / [VSCode](https://code.visualstudio.com/) / [Beekeeper](https://www.beekeeperstudio.io/)

## Sobre

Aprendendo a utilizar do zero o Docker e todas as suas funcionalidades, com um projeto em que engloba Java e Mysql


## Inicio


Docker é uma plataforma que permite empacotar, distribuir e rodar aplicações de forma leve e isolada usando containers. É como se você colocasse sua aplicação e tudo que ela precisa como dependências, sistema, configs, etc, dentro de uma caixinha portátil, que roda igual em qualquer lugar; no seu PC, no servidor, na nuvem. Em outras palavras ao invés de você baixar e instalar o MySQL no seu computador você instala ele via docker. Podemos atuar com ele via aplicação desktop e também por terminal(O mais comum a ser usado).

O primeiro passo é baixar e instalar o [Docker](https://www.docker.com/products/docker-desktop/) no computador. 

Nesse projeto irei utilizar o [VSCode](https://code.visualstudio.com/) tanto para desenvolvener em Java quanto para utilizar o terminal com o docker.

Agora iremos entender como o docker funciona, no terminal(qualquer terminal, eu vou usar o do VScode) digite o comando "docker images:


![imagem local](/imagens_readme/terminal/docker_images.png)


Essas são as imagens que estão no meu docker, são imagens antigas que foram criadas para outros projetos passados. Repository é o nome do programa, da imagem que você baixou, como posteSQL, MySQL, etc, a TAG se refere a versão daquela imagem, o imagem id é como se fosse o CPF da minha imagem, é unico, você pode referir com esse id com outros comandos docker, para remover por exemplo.


Existe um site chamado [Docker Hub](https://hub.docker.com/) é basicamente um repositório na nuvem para imagens, ele serve basicamente como um "GitHub para containers". No site você pode também criar e adicionar seu próprio container e para baixar outros:



![imagem local](/imagens_readme/docker_hub/imagem_mysql.png)


O exemplo dessa imagem, da tecnologia MySQL para banco de dados, na esquerda ha a aba tags onde você pode pesquisar qual versão usar com links contendo a funcionalidade e atualização de cada versão, a direta está o comando para rodar no terminal para baixar, dessa forma:


![imagem local](/imagens_readme/terminal/baixando_mysql.png)


Como não utilizamos nenhuma referencia a tag, ele irá baixar a ultima versão, para você baixar alguma versão em particular bastar utilizar o comando: docker pull msql:(aqui entra o numero da versão que você pesquisou na aba tag no docker hub).


Agora precisamos rodar o container do MySQL, apenas baixamos a imagem só com isso não podemos utilizar. No docker hub na aba da imagem do MySQL, mais abaixo, existe um tópico de como rodar uma imagem do MySQL:


![imagem local](/imagens_readme/docker_hub/rodando_container_com_run.png)



Esse é o comando base, precisamos configurar ainda. Em "--name" aqui colocamos o nome do nosso container, o "-e" vai servir para configurar login e senha do Mysql, por padrão o login do mysql é root, o "-d" é para configurar a versão da tag do myql, como não colocamos versão iremos deixar apenas como está, também iremos adicionar o "-p" para configuar a porta do mysql e a porta do nosso pc:


![imagem local](imagens_readme/terminal/rodando_container_com_run_terminal.png)


Depois que rodou com sucesso utilizei o comando "docker ps" para exibir os container que estão rodando.



## Utilizando o Beekeeper


"O [Beekeeper Studio](https://www.beekeeperstudio.io/)  é um editor SQL e gerenciador de bancos de dados moderno, de código aberto e multiplataforma (disponível para Windows, macOS e Linux). Ele oferece uma interface gráfica intuitiva que facilita a conexão, consulta e gerenciamento de diversos sistemas de bancos de dados.​ " Você pode baixar e utilizar facilmente ele é um arquivo executavel.


Depois de baixar e executar, vamos nos conectar com nosso MySQL rodando no docker:


![imagem local](/imagens_readme/beekeper/conectando_com_msql.png)


Primeira coisa que você vai fazer é ir na aba "new conections" selecionar o MySQL, e configurar. Basicamente em host e port, aqui você vai por o localhost que é o padrão para rede local do pc, e a port é a que configuramos executamos o container. Precisamos colocar o user e password, e também o Save connection (Que é o nome da nossa aplicação MySQL). Depois iremos testar nosso aplicação criando um Database e tabelas e colunas:


![imagem local](imagens_readme/beekeper/criando_banco_tabela_e_inserindo_pessoa.png)


Seguindo esses passos, primeiro criando o database, segundo você precisa selecionar ele para que os outros comandos funcione, e então você cria tabela  e em seguida insere, por mim você da um select.


## Comandos Docker


Aqui vou mostrar os comandos básicos e útils do docker. Primeiro iremos recaptular os comandos que aprendemos, o primeiro foi o "docker images", ele serve para listar nossas imagens baixadas do docker hub. Depois aprendendos a criar uma imagem com "docker pull (nome da imagem : Versão da imagem). Depois aprendemos a rodar um container a partir da imagem baixada com o comando "docker run " onde existem algums parametros a se configurar dependendo da imagem, em seguida o comando "docker ps" para listar nossos container que estão rodando.


#### Docker Stop


Você pode parar o container com o comando docker stop (nome ou id):



![imagem local](/imagens_readme/tudo_sobre_docker/parando_um_container_com_dockerstop.png)


Dessa forma se você tentar acessar o mysql pelo beekeeper, ele não vai conseguir conexão




#### Docker Start


Para rodar novamente um container já criado basta chamar o comando docker start(nome ou id):


![imagem local](/imagens_readme/tudo_sobre_docker/startando_container.png)


repare que eu utilizei o comando docker ps -a, ele serve para listar todos os container criados e seus status, dessa forma se você não sabe o nome ou id do container que você quer startar você pode utilizar dessa forma


#### Docker delete


Para encerrar a parte de comandos básicos de docker o delete:


![imagem local](/imagens_readme/tudo_sobre_docker/deletando_um_container.png)


Eu baixei uma imagem e startei um contaier do mongoDB para ilustrar o delete, repare que o container está rodando ou up, e quando eu tento deletar um container que está up ele me retornar erro. Eu preciso primeiro stopar o container para depois deletar, repare que no comando stop eu digitei apenas alguns numeros do qual se refere ao container do mongoDB, e ele reconhece, você pode fazer dessa forma, desde que não tenha outro container com essas iniciais. Por fim o comando para deletar usado é o "docker rm (id ou nome).


## Adicionado Java


Nesse capitulo vamos adicionar java e Spring para servir de exemplo para nossas aplicações com o docker. O primeiro passo é ir até o site do [spring initialzr](https://start.spring.io/), ele vai criar uma base para nossa aplicação spring já com a dependencia Spring Web:


![imagem local](imagens_readme/spring_initializr.png)



Proximo passo no nosso VSCode é criar a classe Convidados:



![imagem local](imagens_readme/spring/classe_Convidados.png)


E a classe ConvidadosController:


![imagem local](imagens_readme/spring/classe_ConvidadosController.png)


Depois de rodar para testar o resultado é:


![imagem local](/imagens_readme/bowser/localhost8080.png)



## Criando Imagem e Container


Para criar uma imagem no docker, existe um padrão em que podemos consultar no [dockerdocs no file reference](https://docs.docker.com/reference/dockerfile/), lá encontramos todas as informações sobre comandos, passo a passo, e tudo sobre. O primeiro passo é criar um Dockerfile na nossa aplicação, para facilitar o processo criaremos na pasta raiz da aplicação:


![imagem local](/imagens_readme/criação_dockerfile.png)


Agora iremos editar esse arquivo. O primeiro parametro que iremos urilizar é o FROM, ele vai dizer qual é a imagem base que eu vou utilizar para criar a minha imagem costumizada, como caso eu quero criar uma imagem java iremos colocar o "openjdk" seguindo da tag que no caso é a versão do jdk, no caso eu estou utilizando a versão 21 no meu pc, então ficaria: "openjdk:21". O proximo comando é chamado de WORKDIR, ele serve para criar uma pasta dentro da imagem que estou criando para copiar, remover, iniciar arquivos dentro dessa pasta. O proximo passo é utilzar o comando COPY ele literalmente serve para copiar algum arquivo que no caso é o arquivo .jar criado a partir do processo de build e deploy do maven, então eu vou utilizar o caminho até o arquivo para copiar ele para a pasta que eu criei com o WORKDIR. O proximo comando é o ENTRYPOINT ele serve para  dizer ao Docker que, ao rodar o container, ele deve executar esse comando, que no nosso caso que ele deve executar o arquivo jar copiado para nova pasta com o comando java.


![imagem local](/imagens_readme/tudo_sobre_docker/primeiro_passo_para_criar_uma_imagemDocker.png)


O proximo passo é buildar essa imagem:


![imagem local](/imagens_readme/tudo_sobre_docker/criando_container_do_meu_projeto_java.png)



Uma observação a se fazer é na criação de uma imagem utilizamos o --tag para dar o nome da imagem, já na criação de um container utilizamos o -name para dar nome ao container. Vamos verificar agora se a imagem foi criada com sucesso:


![imagem local](/imagens_readme/tudo_sobre_docker/observando_criacao_de_imagem.png)



Tudo certo na criação de imagem. Agora iremos criar um container a partir dessa imagem:



![imagem local](/imagens_readme/tudo_sobre_docker/criando_container_do_projeto_java1.png)



Não tem muito mistério na criação de um container, o que precisamos nos atentar é na porta -p 8080:8080, o segundo parametro da porta depois dos :, é o parametro da porta da aplicação java/spring, que por padrão sempre será 8080 então não a modifique, já o primeiro você pode modificar, com ela iremos entrar na aplicação. Para ilutrar esse exemplo irei criar mais um  container com diferente porta:


![imagem local](/imagens_readme/tudo_sobre_docker/criando_container_do_projeto_java2.png)



Primeiro eu adicionei um novo terminal por que o container java que eu criei está ocupando o terminal, depois eu utilizei um novo nome e outra porta diferente para acessar. Na pratíca podemos acessar aos duas portas:


Com a porta 8080:


![imagem local](/imagens_readme/bowser/localhost8080.png)



Com a porta 8081:


![imagem local](/imagens_readme/bowser/localhost8081.png)



Agora irei deletar os dois container para criar um que não ocupe o meu terminal ao inicializar.



![imagem local](/imagens_readme/tudo_sobre_docker/deletando_novos_containers.png)



Agora irei criar um novo container:


![imagem local](/imagens_readme/tudo_sobre_docker/criando_container_Java_com_domaim.png)



Quando utilizamos o parametro -d na criação de um container Docker ele rodara o container em detached mode", ou seja, executar o container em segundo plano. A vantagem literalmente desocupar meu terminal e poder stopar o container com id gerado ao criar com esse parametro.









