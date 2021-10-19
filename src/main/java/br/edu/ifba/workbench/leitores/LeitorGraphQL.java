package br.edu.ifba.workbench.leitores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.CorpoRequisicaoGraphQL;
import br.edu.ifba.workbench.modeladores.ModeladorGraphQLDesaparecimentos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LeitorGraphQL implements ILeitorDados {

  private static final Logger LOGGER = LoggerFactory.getLogger(LeitorGraphQL.class);

  private final ClienteGraphQL clienteGraphQL;
  private final ModeladorGraphQLDesaparecimentos modeladorGraphQL;

  public LeitorGraphQL(String urlServidorGraphQL) {
    this.clienteGraphQL = new ClienteGraphQL(urlServidorGraphQL);
    this.modeladorGraphQL = new ModeladorGraphQLDesaparecimentos();
  }

  @Override
  public void ler() throws IOException {
//    String queryDeDesaparecimentos = this.modeladorGraphQL.montarQueryDeDesaparecimentos();
    String queryDeDesaparecimentos = this.modeladorGraphQL.montarQueryDeTotalDeDesaparecimentos();
    String respostaApi = this.clienteGraphQL.executar(
      CorpoRequisicaoGraphQL.builder()
        .query(queryDeDesaparecimentos)
        .build()
    );
//    LOGGER.info("Resposta da API GraphQL para chamada de leitura de desaparecimentos: {}", respostaApi);
  }

}
