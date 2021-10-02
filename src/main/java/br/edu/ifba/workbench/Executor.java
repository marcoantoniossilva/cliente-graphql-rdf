package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.EscritorGraphQL;
import br.edu.ifba.workbench.escritores.EscritorRDF;
import br.edu.ifba.workbench.leitores.LeitorGraphQL;
import br.edu.ifba.workbench.leitores.LeitorRDF;
import br.edu.ifba.workbench.testes.ITestador;
import br.edu.ifba.workbench.testes.ResultadoTeste;
import br.edu.ifba.workbench.testes.Testador;

public class Executor {

  public static void main(String[] args) {
    ITestador testador = new Testador();

    // RDF Tests
    ResultadoTeste resultadoTesteEscritaRDF = testador.testarEscrita(new EscritorRDF());
    ResultadoTeste resultadoTesteLeituraRDF = testador.testarLeitura(new LeitorRDF());

    // GraphQL Tests
    ResultadoTeste resultadoTesteEscritaGraphQL = testador.testarEscrita(new EscritorGraphQL());
    ResultadoTeste resultadoTesteLeituraGraphQL = testador.testarLeitura(new LeitorGraphQL());
  }

}
