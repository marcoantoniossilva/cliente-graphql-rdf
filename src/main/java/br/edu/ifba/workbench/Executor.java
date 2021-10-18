package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.EscritorGraphQL;
import br.edu.ifba.workbench.escritores.EscritorRDF;
import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.FakerGeradorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.leitores.LeitorGraphQL;
import br.edu.ifba.workbench.leitores.LeitorRDF;
import br.edu.ifba.workbench.modelos.Desaparecimento;
import br.edu.ifba.workbench.testes.ITestador;
import br.edu.ifba.workbench.testes.ResultadoTeste;
import br.edu.ifba.workbench.testes.Testador;
import br.edu.ifba.workbench.utilitarios.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Executor {

  private static final Logger LOGGER = LoggerFactory.getLogger(Executor.class);

  public static void main(String[] args) {
    LOGGER.info("Inicializando aplicação Java versão 16.");
    LOGGER.info("Servidor GraphQL localizado em {}", Constantes.URL_SERVIDOR_GRAPHQL);
    LOGGER.info("Ontologia RDF localizada em {}", Constantes.URI_ONTOLOGIA_RDF);

    // Dependência comum GraphQL e RDF
    IGeradorDados geradorDados = new FakerGeradorDados();

    // Dependências do GRAPHQL
//    IEscritorDados escritorGraphQL = new EscritorGraphQL(Constantes.URL_SERVIDOR_GRAPHQL);
//    ILeitorDados leitorGraphQL = new LeitorGraphQL(Constantes.URL_SERVIDOR_GRAPHQL);

    // Dependências do RDF
    IEscritorDados escritorRDF = new EscritorRDF(Constantes.URI_ONTOLOGIA_RDF);
    ILeitorDados leitorRDF = new LeitorRDF(Constantes.URI_ONTOLOGIA_RDF);


    Povoador povoador = new Povoador(escritorRDF, geradorDados);
    //povoador.povoarDados();

    // Lista de desaparecimentos utilizada nos testes de escrita RDF e GraphQL
    List<Desaparecimento> desaparecimentos = geradorDados.gerarDesaparecimentos(
        Constantes.qtdDesaparecimentosParaGerar,
        Constantes.qtdPessoasParaGerar,
        Constantes.qtdLocaisParaGerar);

//    ITestador testadorGraphQL = new Testador(escritorGraphQL, leitorGraphQL);
    ITestador testadorRDF = new Testador(escritorRDF, leitorRDF);

    // Testes RDF
    //ResultadoTeste resultadoTesteEscritaRDF = testadorRDF.testarEscrita(desaparecimentos);
    ResultadoTeste resultadoTesteLeituraRDF = testadorRDF.testarLeitura();

   // LOGGER.info("ResultadoTesteEscritaRDF: {}", resultadoTesteEscritaRDF);
    LOGGER.info("ResultadoTesteLeituraRDF: {}", resultadoTesteLeituraRDF);

    // Testes GraphQL
//    ResultadoTeste resultadoTesteEscritaGraphQL = testadorGraphQL.testarEscrita(desaparecimentos);
//    ResultadoTeste resultadoTesteLeituraGraphQL = testadorGraphQL.testarLeitura();

//    LOGGER.info("ResultadoTesteEscritaGraphQL: {}", resultadoTesteEscritaGraphQL);
//    LOGGER.info("ResultadoTesteLeituraGraphQL: {}", resultadoTesteLeituraGraphQL);
  }

}
