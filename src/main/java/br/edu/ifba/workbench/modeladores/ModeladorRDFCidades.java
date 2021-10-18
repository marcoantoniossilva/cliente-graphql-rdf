package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Cidade;
import br.edu.ifba.workbench.utilitarios.Constantes;

import java.util.List;

public class ModeladorRDFCidades {

  private static final String MODELO_INSERT_CRIAR_CIDADES = """
      INSERT DATA {
        Cidades
      }""";

  private static final String MODELO_CIDADE = """
        relembrar:CidadeCOD_CIDADE relembrar:eCidadeDe relembrar:UfCOD_UF . 
        relembrar:CidadeCOD_CIDADE relembrar:nomeCidade 'NOME_CIDADE'^^xsd:string . 
        relembrar:CidadeCOD_CIDADE rdf:type relembrar:Cidade .
      """;

  public String montarInsertDeCidades(List<Cidade> cidades) {
    String cidadesFormatadas = cidades.stream()
        .reduce(new StringBuilder(),
            (modelo, cidade) -> modelo.append(
                MODELO_CIDADE
                    .replace("COD_CIDADE", cidade.getCodCidade().toString())
                    .replace("NOME_CIDADE", cidade.getNomeCidade())
                    .replace("COD_UF", cidade.getCodUf().toString())
            ),
            StringBuilder::append
        ).toString();

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_CIDADES.replace("Cidades", cidadesFormatadas));
  }

  public String montarSelectDeCidades() {
    return Constantes.PREFIXO + """
        SELECT ?nomeCidade ?sigla
        WHERE {
          ?cidade ?a ?uf .
          ?cidade relembrar:eCidadeDe ?uf .
          ?cidade relembrar:nomeCidade ?nomeCidade .
          ?uf relembrar:sigla ?sigla .
        }""";
  }
}
