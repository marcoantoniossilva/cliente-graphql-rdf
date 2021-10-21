package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.EscritorRDF;
import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.leitores.LeitorRDF;
import br.edu.ifba.workbench.testes.ITestador;
import br.edu.ifba.workbench.testes.ResultadoTeste;
import br.edu.ifba.workbench.testes.Testador;
import br.edu.ifba.workbench.utilitarios.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorLeituraRDF {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorLeituraRDF.class);

  public static void main(String[] args) {
    LOGGER.info("Inicializando aplicação Java versão 16.");
    LOGGER.info("Ontologia RDF localizada em {}", Constantes.URI_ONTOLOGIA_RDF);

    // Dependências do RDF
    IEscritorDados escritorRDF = new EscritorRDF(Constantes.URI_ONTOLOGIA_RDF);
    ILeitorDados leitorRDF = new LeitorRDF(Constantes.URI_ONTOLOGIA_RDF);

    ITestador testadorRDF = new Testador(escritorRDF, leitorRDF);

    // Teste de leitura
    ResultadoTeste resultadoTesteLeituraRDF = testadorRDF.testarLeitura();

    LOGGER.info("ResultadoTesteLeituraRDF: {}", resultadoTesteLeituraRDF);

  }

}
