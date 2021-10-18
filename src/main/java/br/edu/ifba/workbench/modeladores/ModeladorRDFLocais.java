package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Local;
import br.edu.ifba.workbench.utilitarios.Constantes;

import java.util.List;

public class ModeladorRDFLocais {

  private static final String MODELO_INSERT_CRIAR_LOCAIS = """
      INSERT DATA {
        Locais
      }""";

  private static final String MODELO_LOCAL = """
        relembrar:LocalCOD_LOCAL relembrar:eUmPontoDe relembrar:BairroCOD_BAIRRO . 
        relembrar:LocalCOD_LOCAL relembrar:latitude 'LATITUDE_LOCAL'^^xsd:decimal . 
        relembrar:LocalCOD_LOCAL relembrar:longitude 'LONGITUDE_LOCAL'^^xsd:decimal . 
        relembrar:LocalCOD_LOCAL rdf:type relembrar:Local .
      """;

  public String montarInsertDeLocais(List<Local> locais) {
    String locaisFormatadas = locais.stream()
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

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_LOCAIS.replace("Locais", locaisFormatadas));
  }

  public String montarSelectDeLocais() {
    return Constantes.PREFIXO + """
        SELECT ?latitude ?longitude ?nomeBairro
        WHERE {
          ?local ?c ?bairro .
          ?local relembrar:eUmPontoDe ?bairro .
          ?bairro relembrar:nomeBairro ?nomeBairro .
          ?local relembrar:latitude ?latitude .
          ?local relembrar:longitude ?longitude .
        }""";
  }
}
