package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.Desaparecimento;
import br.edu.ifba.workbench.modelos.ModeladorGraphQLDesaparecimentos;

import java.io.IOException;
import java.util.List;

public class EscritorGraphQL implements IEscritorDados {

  private final ClienteGraphQL clienteGraphQL;
  private final ModeladorGraphQLDesaparecimentos modeladorGraphQL;

  public EscritorGraphQL(String urlServidorGraphQL) {
    this.clienteGraphQL = new ClienteGraphQL(urlServidorGraphQL);
    this.modeladorGraphQL = new ModeladorGraphQLDesaparecimentos();
  }

  @Override
  public void escrever(List<Desaparecimento> desaparecimentos) throws IOException {
    String mutationDeDesaparecimentos = this.modeladorGraphQL.montarMutationDeDesaparecimentos(desaparecimentos);
    System.out.println(mutationDeDesaparecimentos);
//    String respostaApi = this.clienteGraphQL.executar(
//      CorpoRequisicaoGraphQL.builder()
//        .query(mutationDeDesaparecimentos)
//        .build()
//    );
//    System.out.printf("Resposta da API: %s", respostaApi);
  }

}
