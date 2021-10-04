package br.edu.ifba.workbench.modelos;

import java.util.List;

public class ModeladorGraphQLDesaparecimentos {

  private static final String MODELO_DESAPARECIMENTO = """
    {
      codDesaparecimento: COD_DESAP
      codPessoa: COD_PESS
      codLocal: COD_LOC
      dataDesaparecimento: "DATA_DESAP"
      informacoes: "INFO"
      fonte: "FONTE"
      boletimOcorrencia: BOLETIM
      ultimaHoraVista: "ULTIMA_HORA"
    }
    """;

  private static final String MODELO_MUTATION_CRIAR_DESAPARECIMENTOS = """
    mutation {
      criarDesaparecimentos(
        data: [
          DESAPARECIMENTOS
        ]
      ) {
        codDesaparecimento
      }
    }
    """;

  public String montarMutationDeDesaparecimentos(List<Desaparecimento> desaparecimentos) {
    String desaparecimentosFormatados = desaparecimentos.stream()
      .reduce(new StringBuilder(),
        (modelo, desaparecimento) ->  modelo.append(
          MODELO_DESAPARECIMENTO
            .replace("COD_DESAP", desaparecimento.getCodDesaparecimento().toString())
            .replace("COD_PESS", desaparecimento.getCodPessoa().toString())
            .replace("COD_LOC", desaparecimento.getCodLocal().toString())
            .replace("DATA_DESAP", desaparecimento.getDataDesaparecimento())
            .replace("INFO", desaparecimento.getInformacoes())
            .replace("FONTE", desaparecimento.getFonte())
            .replace("BOLETIM", String.valueOf(desaparecimento.isBoletimOcorrencia()))
            .replace("ULTIMA_HORA", desaparecimento.getUltimaHoraVista())
        ),
        StringBuilder::append
      ).toString();

    return MODELO_MUTATION_CRIAR_DESAPARECIMENTOS.replace("DESAPARECIMENTOS", desaparecimentosFormatados);
  }

  public String montarQueryDeDesaparecimentos() {
    return """
      query{
        desaparecimentos{
          local{
            bairro{
              nomeBairro
            }
          }
        }
      }
      """;
  }

}
