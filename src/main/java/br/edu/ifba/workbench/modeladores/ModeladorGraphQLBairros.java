package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Bairro;

import java.util.List;

public class ModeladorGraphQLBairros {

  private static final String MODELO_BAIRRO = """
      {
        codBairro: COD_BAIRRO
        codCidade: COD_CIDADE
        nomeBairro: "NOME_BAIRRO"
      }
      """;

  private static final String MODELO_MUTATION_CRIAR_BAIRROS = """
      mutation {
        criarBairros(
          data: [
            BAIRROS
          ]
        ) {
          codBairro
        }
      }
      """;

  public String montarMutationDeBairros(List<Bairro> bairros) {
    String bairrosFormatados = bairros.stream()
        .reduce(new StringBuilder(),
            (modelo, bairro) -> modelo.append(
                MODELO_BAIRRO
                    .replace("COD_BAIRRO", bairro.getCodBairro().toString())
                    .replace("COD_CIDADE", bairro.getCodCidade().toString())
                    .replace("NOME_BAIRRO", bairro.getNomeBairro())
            ),
            StringBuilder::append
        ).toString();

    return MODELO_MUTATION_CRIAR_BAIRROS.replace("BAIRROS", bairrosFormatados);
  }

  public String montarQueryDeBairros() {
    return """
        query {
          bairros {
            codBairro
            nomeBairro
            cidade {
              nomeCidade
            }
          }
        }
        """;
  }

}
