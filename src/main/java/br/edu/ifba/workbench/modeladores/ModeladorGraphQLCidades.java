package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Cidade;

import java.util.List;

public class ModeladorGraphQLCidades {

  private static final String MODELO_CIDADE = """
      {
        codCidade: COD_CIDADE
        codUf: COD_UF
        nomeCidade: "NOME_CIDADE"
      }
      """;

  private static final String MODELO_MUTATION_CRIAR_CIDADES = """
      mutation {
        criarCidades(
          data: [
            CIDADES
          ]
        ) {
          codCidade
        }
      }
      """;

  public String montarMutationDeCidades(List<Cidade> cidades) {
    String cidadesFormatadas = cidades.stream()
        .reduce(new StringBuilder(),
            (modelo, cidade) -> modelo.append(
                MODELO_CIDADE
                    .replace("COD_CIDADE", cidade.getCodCidade().toString())
                    .replace("COD_UF", cidade.getCodUf().toString())
                    .replace("NOME_CIDADE", cidade.getNomeCidade())
            ),
            StringBuilder::append
        ).toString();

    return MODELO_MUTATION_CRIAR_CIDADES.replace("CIDADES", cidadesFormatadas);
  }

  public String montarQueryDeCidades() {
    return """
        query {
          cidades {
            codCidade
            uf
            nomeCidade
          }
        }
        """;
  }

}
