package br.edu.ifba.workbench.modeladores;

import java.util.List;

import br.edu.ifba.workbench.modelos.Bairro;
import br.edu.ifba.workbench.utilitarios.Constantes;

public class ModeladorRDFBairros {

  private static final String MODELO_INSERT_CRIAR_BAIRROS = """
      INSERT DATA {
        Bairros
      }""";

  private static final String MODELO_BAIRRO = """
        relembrar:BairroCOD_BAIRRO relembrar:eBairroDe relembrar:CidadeCOD_CIDADE . 
        relembrar:BairroCOD_BAIRRO relembrar:nomeBairro 'NOME_BAIRRO'^^xsd:string . 
        relembrar:BairroCOD_BAIRRO rdf:type relembrar:Bairro .
      """;

  public String montarInsertDeBairros(List<Bairro> bairros) {
    String bairrosFormatadas = bairros.stream()
        .reduce(new StringBuilder(),
            (modelo, bairro) -> modelo.append(
                MODELO_BAIRRO
                    .replace("COD_BAIRRO", bairro.getCodBairro().toString())
                    .replace("NOME_BAIRRO", bairro.getNomeBairro())
                    .replace("COD_CIDADE", bairro.getCodCidade().toString())
            ),
            StringBuilder::append
        ).toString();

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_BAIRROS.replace("Bairros", bairrosFormatadas));
  }

  public String montarSelectDeBairros() {
    return Constantes.PREFIXO + """
        SELECT ?nomeBairro ?nomeCidade
        WHERE {
          ?bairro ?b ?cidade .
          ?bairro relembrar:eBairroDe ?cidade .
          ?bairro relembrar:nomeBairro ?nomeBairro .
          ?cidade relembrar:nomeCidade ?nomeCidade .
        }""";
  }
}
