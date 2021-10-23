# Comparação de tempo de leitura e escrita entre GraphQL e uma ontologia RDF
 
Este sistema possui um cliente [GraphQL](https://graphql.org/) e um cliente RDF que atuam consumindo uma [API GraphQL de desaparecimentos](https://github.com/marcoantoniossilva/api-graphql-desaparecidos) e uma ontologia fruto do [projeto Relembrar](https://ontologiarelembrar.github.io/). O software desenvolvido em [Java](https://www.oracle.com/java/) povoa a API e o RDF com dados fakes por meio da biblioteca [Java Faker](https://github.com/DiUS/java-faker/tree/master/src) e em seguida realiza testes de leitura e escrita na API e na ontologia para fim de comparação.

<br/>

Para rodar o projeto e executar os testes, siga as etapas abaixo:
## 1 - Instale as dependências maven do arquivo [pom.xml](pom.xml)

## 2 - Configure a quantidade de dados a serem gerados no arquivo [Constantes.java](src/main/java/br/edu/ifba/workbench/utilitarios/Constantes.java).

~~~java
public static final Integer QTD_CIDADES_PARA_GERAR = 2500;
public static final Integer QTD_BAIRROS_PARA_GERAR = 5000;
public static final Integer QTD_LOCAIS_PARA_GERAR = 10000;
public static final Integer QTD_PESSOAS_PARA_GERAR = 100000;
public static final Integer QTD_DESAPARECIMENTOS_PARA_GERAR = 10000;
~~~

## 3 - Execute os testes:

### 3.1 Povoando e testando leitura e escrita

Para povoar a API e a ontologia com dados falsos e em seguida realizar os testes de leitura e escrita, execute a classe [Executor.java](src/main/java/br/edu/ifba/workbench/Executor.java).

### 3.2 Testando leitura RDF

Para realizar o teste de **leitura** na ontologia, execute a classe [ExecutorLeituraRDF.java](src/main/java/br/edu/ifba/workbench/ExecutorLeituraRDF.java).

### 3.3 Testando escrita RDF

Para realizar o teste de **escrita** na ontologia, execute a classe [ExecutorEscritaRDF.java](src/main/java/br/edu/ifba/workbench/ExecutorEscritaRDF.java).
<br/>

## Observações

### Fidelização dos resultados

Para fidelizar a comparação entre vários testes, é necessário limpar o banco de dados da API e a ontologia entre cada teste.

* Para limpar o banco de dados da API é necessário rodar os seguintes comandos no SGBD em que o banco está instalado:
~~~sql
DELETE FROM bairros;
DELETE FROM cidades;
DELETE FROM locais;
DELETE FROM pessoas;
DELETE FROM ufs;
DELETE FROM desaparecimentos;
~~~
* Para zerar a ontologia, a [ontologia povoada](src/main/resources/Relembrar.owl) deve ser apagada e uma cópia da [ontologia de backup](src/main/resources/Relembrar.bkp) "Relembrar.bkp" deve ser feita e renomeada para "Relembrar.owl".


<br/>

### Versão somente GraphQL

Existe uma versão deste sistema somente com a parte dos testes de leitura e escrita em GraphQL, para acessá-la, [clique aqui](https://github.com/marcoantoniossilva/cliente-graphql-rdf/releases/tag/v0.1).