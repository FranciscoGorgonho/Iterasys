**Petstore API Test**

Este é um projeto de teste automatizado utilizando a linguagem Java e a biblioteca RestAssured. O objetivo deste projeto é testar as funcionalidades da API da Petstore.

**Funcionalidades testadas**

Incluir um novo pet na loja
Consultar um pet específico por ID
Alterar as informações de um pet existente
Excluir um pet da loja

**Pré-requisitos**

Java JDK 8 ou superior instalado
IDE de desenvolvimento Java (recomendado: IntelliJ IDEA)
Bibliotecas RestAssured e TestNG adicionadas ao projeto

**Como executar**

Clone este repositório
Importe o projeto em sua IDE
Execute a classe Pet.java como um teste do TestNG
Verifique a saída do console para ver os resultados dos testes

**Como funciona**

A classe Pet contém os testes automatizados para as funcionalidades da API da Petstore. A classe possui os seguintes métodos:

lerJson(String caminhoJson): Lê um arquivo JSON e retorna o conteúdo como uma string.
incluirPet(): Testa a funcionalidade de incluir um novo pet na loja.
consultarPet(): Testa a funcionalidade de consultar um pet específico por ID.
alterarPet(): Testa a funcionalidade de alterar as informações de um pet existente.
excluirPet(): Testa a funcionalidade de excluir um pet da loja.
Cada método representa um teste automatizado específico e é executado pelo framework TestNG. Os testes realizam requisições HTTP para a API da Petstore utilizando a biblioteca RestAssured e validam as respostas recebidas.

Os testes utilizam a sintaxe **Gherkin** para organizar as etapas do teste em três partes: Dado, Quando e Então (Given, When, Then). Cada parte é representada por uma função da biblioteca RestAssured, e a validação dos resultados é realizada utilizando as funções de validação do TestNG.

**Autor**
Este projeto foi criado por Francisco Gorgonho como parte de um curso de testes de API.