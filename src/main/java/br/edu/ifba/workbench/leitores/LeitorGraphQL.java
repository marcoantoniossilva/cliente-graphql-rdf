package br.edu.ifba.workbench.leitores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.CorpoRequisicaoGraphQL;
import br.edu.ifba.workbench.modelos.ModeladorGraphQLDesaparecimentos;

import java.io.IOException;

public class LeitorGraphQL implements ILeitorDados {

  private final ClienteGraphQL clienteGraphQL;
  private final ModeladorGraphQLDesaparecimentos modeladorGraphQL;

  public LeitorGraphQL(String urlServidorGraphQL) {
    this.clienteGraphQL = new ClienteGraphQL(urlServidorGraphQL);
    this.modeladorGraphQL = new ModeladorGraphQLDesaparecimentos();
  }

  @Override
  public void ler() throws IOException {
    String queryDeDesaparecimentos = this.modeladorGraphQL.montarQueryDeDesaparecimentos();
    this.clienteGraphQL.executar(
      CorpoRequisicaoGraphQL.builder()
        .query(queryDeDesaparecimentos)
        .build()
    );
  }

}
