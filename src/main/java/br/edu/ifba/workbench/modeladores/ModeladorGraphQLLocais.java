package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Local;

import java.util.List;

public class ModeladorGraphQLLocais {

  private static final String MODELO_LOCAL = """
      {
        codLocal: COD_LOCAL
        codBairro: COD_BAIRRO
        latitude: "LATITUDE_LOCAL"
        longitude: "LONGITUDE_LOCAL"
      }
      """;

  private static final String MODELO_MUTATION_CRIAR_LOCAIS = """
      mutation {
        criarLocais(
          data: [
            LOCAIS
          ]
        ) {
          codLocal
        }
      }
      """;

  public String montarMutationDeLocais(List<Local> locais) {
    String locaisFormatados = locais.stream()
        .reduce(new StringBuilder(),
            (modelo, local) -> modelo.append(
                MODELO_LOCAL
                    .replace("COD_LOCAL", local.getCodLocal().toString())
                    .replace("COD_BAIRRO", local.getCodBairro().toString())
                    .replace("LATITUDE_LOCAL", local.getLatitude())
                    .replace("LONGITUDE_LOCAL", local.getLongitude())
            ),
            StringBuilder::append
        ).toString();

    return MODELO_MUTATION_CRIAR_LOCAIS.replace("LOCAIS", locaisFormatados);
  }

  public String montarQueryDeLocais() {
    return """
        query {
          locais {
            codLocal
            latitude
            longitude
            bairro {
              nomeBairro
            }
          }
        }
        """;
  }

}
