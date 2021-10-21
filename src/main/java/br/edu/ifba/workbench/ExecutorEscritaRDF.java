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
import br.edu.ifba.workbench.povoadores.Povoador;
import br.edu.ifba.workbench.testes.ITestador;
import br.edu.ifba.workbench.testes.ResultadoTeste;
import br.edu.ifba.workbench.testes.Testador;
import br.edu.ifba.workbench.utilitarios.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ExecutorEscritaRDF {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorEscritaRDF.class);

  public static void main(String[] args) {
    LOGGER.info("Inicializando aplicação Java versão 16.");
    LOGGER.info("Ontologia RDF localizada em {}", Constantes.URI_ONTOLOGIA_RDF);

    // Gerador de dados falsos
    IGeradorDados geradorDados = new FakerGeradorDados();

    // Dependências do RDF
    IEscritorDados escritorRDF = new EscritorRDF(Constantes.URI_ONTOLOGIA_RDF);
    ILeitorDados leitorRDF = new LeitorRDF(Constantes.URI_ONTOLOGIA_RDF);

    // Criação da lista de desaparecimentos para testes de leitura/escrita em RDF e GraphQL
    List<Desaparecimento> desaparecimentos = geradorDados.gerarDesaparecimentos(
        Constantes.DadosPadrao.QTD_DESAPARECIMENTOS_PARA_GERAR,
        Constantes.DadosPadrao.QTD_PESSOAS_PARA_GERAR,
        Constantes.DadosPadrao.QTD_LOCAIS_PARA_GERAR);

    ITestador testadorRDF = new Testador(escritorRDF, leitorRDF);

    // Testes RDF
    ResultadoTeste resultadoTesteEscritaRDF = testadorRDF.testarEscrita(desaparecimentos);

    LOGGER.info("ResultadoTesteEscritaRDF: {}", resultadoTesteEscritaRDF);

  }

}
