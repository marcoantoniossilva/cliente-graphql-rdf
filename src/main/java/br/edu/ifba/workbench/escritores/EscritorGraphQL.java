package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modeladores.*;
import br.edu.ifba.workbench.modelos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class EscritorGraphQL implements IEscritorDados {

  private static final Logger LOGGER = LoggerFactory.getLogger(EscritorGraphQL.class);

  private final ClienteGraphQL clienteGraphQL;
  private final ModeladorGraphQLDesaparecimentos modeladorGraphQLDesaparecimentos;
  private final ModeladorGraphQLPessoas modeladorGraphQLPessoas;
  private final ModeladorGraphQLUfs modeladorGraphQLUfs;
  private final ModeladorGraphQLCidades modeladorGraphQLCidades;
  private final ModeladorGraphQLBairros modeladorGraphQLBairros;
  private final ModeladorGraphQLLocais modeladorGraphQLLocais;


  public EscritorGraphQL(String urlServidorGraphQL) {
    this.clienteGraphQL = new ClienteGraphQL(urlServidorGraphQL);
    this.modeladorGraphQLDesaparecimentos = new ModeladorGraphQLDesaparecimentos();
    this.modeladorGraphQLPessoas = new ModeladorGraphQLPessoas();
    this.modeladorGraphQLUfs = new ModeladorGraphQLUfs();
    this.modeladorGraphQLCidades = new ModeladorGraphQLCidades();
    this.modeladorGraphQLBairros = new ModeladorGraphQLBairros();
    this.modeladorGraphQLLocais = new ModeladorGraphQLLocais();
  }

  @Override
  public void escreverDesaparecimentos(List<Desaparecimento> desaparecimentos) throws IOException {
    String mutationDeDesaparecimentos = this.modeladorGraphQLDesaparecimentos.montarMutationDeDesaparecimentos(desaparecimentos);
    String respostaApi = chamarClienteGraphQL(mutationDeDesaparecimentos);
  }

  @Override
  public void escreverUfs(List<Uf> ufs) throws IOException {
    String mutationDeUfs = this.modeladorGraphQLUfs.montarMutationDeUfs(ufs);
    String respostaApi = chamarClienteGraphQL(mutationDeUfs);
  }

  @Override
  public void escreverCidades(List<Cidade> cidades) throws IOException {
    String mutationDeCidades = this.modeladorGraphQLCidades.montarMutationDeCidades(cidades);
    String respostaApi = chamarClienteGraphQL(mutationDeCidades);
  }

  @Override
  public void escreverBairros(List<Bairro> bairros) throws IOException {
    String mutationDeBairros = this.modeladorGraphQLBairros.montarMutationDeBairros(bairros);
    String respostaApi = chamarClienteGraphQL(mutationDeBairros);
  }

  @Override
  public void escreverLocais(List<Local> locais) throws IOException {
    String mutationDeLocais = this.modeladorGraphQLLocais.montarMutationDeLocais(locais);
    String respostaApi = chamarClienteGraphQL(mutationDeLocais);
  }

  @Override
  public void escreverPessoas(List<Pessoa> pessoas) throws IOException {
    String mutationDePessoas = this.modeladorGraphQLPessoas.montarMutationDePessoas(pessoas);
    String respostaApi = chamarClienteGraphQL(mutationDePessoas);
  }

  public String chamarClienteGraphQL(String mutation) throws IOException {
    return this.clienteGraphQL.executar(
        CorpoRequisicaoGraphQL.builder()
            .query(mutation)
            .build()
    );
  }

}
