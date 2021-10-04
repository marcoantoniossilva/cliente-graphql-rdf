package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.EscritorGraphQL;
import br.edu.ifba.workbench.escritores.EscritorRDF;
import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.FakerGeradorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.leitores.LeitorGraphQL;
import br.edu.ifba.workbench.leitores.LeitorRDF;
import br.edu.ifba.workbench.testes.ITestador;
import br.edu.ifba.workbench.testes.ResultadoTeste;
import br.edu.ifba.workbench.testes.Testador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Executor {

  private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);
  private static final String URL_SERVIDOR_GRAPHQL = "http://localhost:4000";

  public static void main(String[] args) {
    LOGGER.info("Inicializando aplicação Java versão 16.");
    LOGGER.info("Servidor GraphQL localizado em {}", URL_SERVIDOR_GRAPHQL);

    // Dependência comum GraphQL e RDF
    IGeradorDados geradorDados = new FakerGeradorDados();

    // Dependências do GRAPHQL
    IEscritorDados escritorGraphQL = new EscritorGraphQL(URL_SERVIDOR_GRAPHQL);
    ILeitorDados leitorGraphQL = new LeitorGraphQL(URL_SERVIDOR_GRAPHQL);

    // Dependências do RDP
    IEscritorDados escritorRDF = new EscritorRDF();
    ILeitorDados leitorRDF = new LeitorRDF();

    ITestador testadorGraphQL = new Testador(escritorGraphQL, leitorGraphQL, geradorDados);
    ITestador testadorRDF = new Testador(escritorRDF, leitorRDF, geradorDados);

    // RDF Testes
    ResultadoTeste resultadoTesteEscritaRDF = testadorRDF.testarEscrita();
    ResultadoTeste resultadoTesteLeituraRDF = testadorRDF.testarLeitura();

    LOGGER.info("ResultadoTesteEscritaRDF: {}", resultadoTesteEscritaRDF);
    LOGGER.info("ResultadoTesteLeituraRDF: {}", resultadoTesteLeituraRDF);

    // GraphQL Testes
    ResultadoTeste resultadoTesteEscritaGraphQL = testadorGraphQL.testarEscrita();
    ResultadoTeste resultadoTesteLeituraGraphQL = testadorGraphQL.testarLeitura();

    LOGGER.info("ResultadoTesteEscritaGraphQL: {}", resultadoTesteEscritaGraphQL);
    LOGGER.info("ResultadoTesteLeituraGraphQL: {}", resultadoTesteLeituraGraphQL);
  }

}
