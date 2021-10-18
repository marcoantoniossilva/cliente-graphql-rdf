package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.*;
import br.edu.ifba.workbench.modeladores.ModeladorGraphQLDesaparecimentos;
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
  public void escreverDesaparecimentos(List<Desaparecimento> desaparecimentos) throws IOException {
    String mutationDeDesaparecimentos = this.modeladorGraphQL.montarMutationDeDesaparecimentos(desaparecimentos);
    String respostaApi = chamarClienteGraphQL(mutationDeDesaparecimentos);
    LOGGER.info("Resposta da API GraphQL para chamada de escrita: {} de desaparecimentos", respostaApi);
  }

  @Override
  public void escreverUfs(List<Uf> ufs) throws IOException {

  }

  @Override
  public void escreverCidades(List<Cidade> cidades) throws IOException {

  }

  @Override
  public void escreverBairros(List<Bairro> bairros) throws IOException {

  }

  @Override
  public void escreverLocais(List<Local> locais) throws IOException {

  }

  @Override
  public void escreverPessoas(List<Pessoa> pessoas) throws IOException {

  }

  public String chamarClienteGraphQL(String mutation) throws IOException {
    return this.clienteGraphQL.executar(
        CorpoRequisicaoGraphQL.builder()
            .query(mutation)
            .build()
    );
  }

}
