# apolice
Sistema de apolice selecao Asap

REQUESITOS
  -MONGODB
  -GRADLE
  -JAVA 8+

[DOWNLOAD E INSTALACAO]
 Clone o repositorio usando o comando git clone https://github.com/Jonathan-Assumpcao/apolice.git
Em seguida navegue até a pasta apolice e digite gradle build

[EXECUTAR]
 Feito isso é possível importar o projeto no eclipse ou executar .jar
Para executar o .jar navegue até a pasta do projeto comn o Prompt e execute: java -jar build/libs/sistema-0.0.1-SNAPSHOT

[CONSUMINDO A API]
GET     -> http://localhost:8080/api/clientes Lista todos os clientes
GET     -> http://localhost:8080/api/clientes/{cpf} Lista todos os clientes filtrado por CPF
POST    -> http://localhost:8080/api Cadastra novo cliente
PUT     -> http://localhost:8080/api/{cpf} Altera registro de cliente
DELETE  -> http://localhost:8080/api/{cpf} Remove cliente

GET     -> http://localhost:8080/api/apolice Lista todos as apolices
GET     -> http://localhost:8080/api/buscaapolice/{numero} Lista apolices filtrando por numero
POST    -> http://localhost:8080/api/apolice/ Cadastra nova apolice 
PUT     -> http://localhost:8080/api/apolice/{numero} Altera dados da apolice
DELETE  -> http://localhost:8080/api/apolice/{numero} Remove apolice do sistema

[EXEMPLOS DE REQUISICOES]
 REQUISICAO PARA CLIENTE:
  {
	"cpf":"000.000.000-00",
	"nome":"Jonathan Lopes Assumpcao",
	"cidade":"Curitiba",
	"uf":"PR"
}

REQUISICAO PARA APOLICE
  {
	"placa":"ABC-1234",
	"dataVigencia": "21/08/2020",
	"dataFim": "21/08/2021",
	"valorApolice": "100.000,00"
}
