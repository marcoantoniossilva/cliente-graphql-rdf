package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Pessoa;

import java.util.List;

public class ModeladorGraphQLPessoas {

  private static final String MODELO_PESSOA = """
      {
        codPessoa: COD_PESSOA
        nome: "NOME_PESSOA"
        dataNascimento: "DATA_NASCIMENTO"
        imagem: "IMAGEM_PESSOA"
        sexo: "SEXO_PESSOA"
        corOlhos: "COR_OLHOS_PESSOA"
        corPele: "COR_PELE_PESSOA"
        corCabelo: "COR_CABELO_PESSOA"
        pesoAproximado: PESO_APROXIMADO_PESSOA
        alturaAproximada: ALTURA_APROXIMADA_PESSOA
        tipoFisico: "TIPO_FISICO_PESSOA"
        transtornoMental: "TRANSTORNO_MENTAL_PESSOA"
        marcaCaracteristica: "MARCA_CARACTERISTICA_PESSOA"
      }
      """;

  private static final String MODELO_MUTATION_CRIAR_PESSOAS = """
      mutation {
        criarPessoas(
          data: [
            PESSOAS
          ]
        ) {
          codPessoa
        }
      }
      """;

  public String montarMutationDePessoas(List<Pessoa> pessoas) {
    String PessoasFormatadas = pessoas.stream()
        .reduce(new StringBuilder(),
            (modelo, pessoa) -> modelo.append(
                MODELO_PESSOA
                    .replace("COD_PESSOA", pessoa.getCodPessoa().toString())
                    .replace("NOME_PESSOA", pessoa.getNome())
                    .replace("DATA_NASCIMENTO", pessoa.getDataNascimento())
                    .replace("IMAGEM_PESSOA", pessoa.getImagem())
                    .replace("SEXO_PESSOA", pessoa.getSexo())
                    .replace("COR_OLHOS_PESSOA", String.valueOf(pessoa.getCorOlhos()))
                    .replace("COR_PELE_PESSOA", pessoa.getCorPele())
                    .replace("COR_CABELO_PESSOA", pessoa.getCorCabelo())
                    .replace("PESO_APROXIMADO_PESSOA", pessoa.getPesoAproximado().toString())
                    .replace("ALTURA_APROXIMADA_PESSOA", pessoa.getAlturaAproximada().toString())
                    .replace("TIPO_FISICO_PESSOA", pessoa.getTipoFisico())
                    .replace("TRANSTORNO_MENTAL_PESSOA", pessoa.getTranstornoMental())
                    .replace("MARCA_CARACTERISTICA_PESSOA", pessoa.getMarcaCaracteristica())
            ),
            StringBuilder::append
        ).toString();

    return MODELO_MUTATION_CRIAR_PESSOAS.replace("PESSOAS", PessoasFormatadas);
  }

  public String montarQueryDePessoas() {
    return """
          query {
            pessoas {
              codPessoa
              nome
              dataNascimento
              imagem
              sexo
              corOlhos
              corPele
              corCabelo
              tipoFisico
              pesoAproximado
              alturaAproximada
              transtornoMental
              marcaCaracteristica
            }
          }
        """;
  }

}
