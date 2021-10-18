package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Uf;

import java.util.List;

public class ModeladorGraphQLUfs {

  private static final String MODELO_UF = """
      {
        codUf: COD_UF,
        sigla: "SIGLA_UF"
      }
      """;

  private static final String MODELO_MUTATION_CRIAR_UFS = """
      mutation {
        criarUfs(
          data: [
            UFS
          ]
        ) {
          codUf
        }
      }
      """;

  public String montarMutationDeUfs(List<Uf> ufs) {
    String ufsFormatados = ufs.stream()
        .reduce(new StringBuilder(),
            (modelo, uf) -> modelo.append(
                MODELO_UF
                    .replace("COD_UF", uf.getCodUf().toString())
                    .replace("SIGLA_UF", uf.getSigla())
            ),
            StringBuilder::append
        ).toString();

    return MODELO_MUTATION_CRIAR_UFS.replace("UFS", ufsFormatados);
  }

  public String montarQueryDeUfs() {
    return """
        query {
          ufs {
            codUf
            sigla
            }
          }
        }
        """;
  }

}
