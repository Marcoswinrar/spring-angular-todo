# Desafio supero  

A simple todo app.  

## Começando  

### Instalação


Primeiro de tudo, é necessário baixar as dependências do projeto.  
Para isso, clonar o repositório completo. Acessar a pasta client e rodar:

```
$ npm install
$ npm start

```

Assim a interface da app ficará disponivel na porta 3000.  
Também é necessário rodar o servidor atráves do STS ou eclipse. O mesmo utiliza o gradle, podendo também ser iniciado com:  

```
gradle :bootRun

```

* Necessário o gradle-cli para rodar desta forma.  
* Também é preciso mudar as configurações da base de dados no arquivo application.properties do spring para que funcione corretamente.
* Fiz alguns testes com JUnit, estando disponivel no seu respectivo pacote. 

### Técnologias e ferramentas  

## Client  

* AngularJS
* NodeJS e express(para subir servidor local de teste).
* Bootstrap

## Server  

* Java 12  
* Spring Boot 2.1.4
* JPA  
* JUNIT
* Gradle  
* MySql  




