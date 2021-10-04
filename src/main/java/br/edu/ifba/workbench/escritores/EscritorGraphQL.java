package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.CorpoRequisicaoGraphQL;
import br.edu.ifba.workbench.modelos.Desaparecimento;
import br.edu.ifba.workbench.modelos.ModeladorGraphQLDesaparecimentos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class EscritorGraphQL implements IEscritorDados {

  private static final Logger LOGGER = LoggerFactory.getLogger(EscritorGraphQL.class);

  private final ClienteGraphQL clienteGraphQL;
  private final ModeladorGraphQLDesaparecimentos modeladorGraphQL;

  public EscritorGraphQL(String urlServidorGraphQL) {
    this.clienteGraphQL = new ClienteGraphQL(urlServidorGraphQL);
    this.modeladorGraphQL = new ModeladorGraphQLDesaparecimentos();
  }

  @Override
  public void escrever(List<Desaparecimento> desaparecimentos) throws IOException {
    String mutationDeDesaparecimentos = this.modeladorGraphQL.montarMutationDeDesaparecimentos(desaparecimentos);
    String respostaApi = this.clienteGraphQL.executar(
      CorpoRequisicaoGraphQL.builder()
        .query(mutationDeDesaparecimentos)
        .build()
    );
    LOGGER.info("Resposta da API GraphQL para chamada de escrita: {} de desaparecimentos", respostaApi);
  }

}
