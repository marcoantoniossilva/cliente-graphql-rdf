package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Uf;
import br.edu.ifba.workbench.utilitarios.Constantes;

import java.util.List;

public class ModeladorRDFUfs {

  private static final String MODELO_INSERT_CRIAR_UFS = """
      INSERT DATA {
        Ufs
      }""";

  private static final String MODELO_UF = """
        relembrar:UfCOD_UF relembrar:sigla 'SIGLA_UF'^^xsd:string . 
        relembrar:UfCOD_UF rdf:type relembrar:UF . 
      """;

  public String montarInsertDeUfs(List<Uf> ufs) {
    String ufsFormatados = ufs.stream()
        .reduce(new StringBuilder(),
            (modelo, uf) -> modelo.append(
                MODELO_UF
                    .replace("COD_UF", uf.getCodUf().toString())
                    .replace("SIGLA_UF", uf.getSigla())
            ),
            StringBuilder::append
        ).toString();

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_UFS.replace("Ufs", ufsFormatados));
  }

  public String montarSelectDeUfs() {
    return Constantes.PREFIXO + """
        SELECT ?sigla
        WHERE {
          ?uf relembrar:sigla ?sigla .
        }""";
  }
}
