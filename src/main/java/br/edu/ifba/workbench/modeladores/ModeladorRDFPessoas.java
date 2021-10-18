package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Pessoa;
import br.edu.ifba.workbench.utilitarios.Constantes;

import java.util.List;

public class ModeladorRDFPessoas {

  private static final String MODELO_INSERT_CRIAR_PESSOAS = """
      INSERT DATA {
        Pessoas
      }""";

  private static final String MODELO_PESSOA = """
        relembrar:PessoaCOD_PESSOA relembrar:imagem 'IMAGEM_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:sexo 'SEXO_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:pesoAproximado 'PESO_APROXIMADO_PESSOA'^^xsd:decimal . 
        relembrar:PessoaCOD_PESSOA relembrar:corPele 'COR_PELE_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:corOlhos 'COR_OLHOS_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:dataNascimento 'DATA_NASCIMENTO_PESSOA'^^xsd:date . 
        relembrar:PessoaCOD_PESSOA relembrar:nome 'NOME_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:tipoFisico 'TIPO_FISICO_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:marcaCaracteristica 'MARCA_CARACTERISTICA_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:alturaAproximada 'ALTURA_APROXIMADA_PESSOA'^^xsd:decimal . 
        relembrar:PessoaCOD_PESSOA relembrar:corCabelo 'COR_CABELO_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA relembrar:transtornoMental 'TRANSTORNO_MENTAL_PESSOA'^^xsd:string . 
        relembrar:PessoaCOD_PESSOA rdf:type relembrar:Pessoa .
      """;

  public String montarInsertDePessoas(List<Pessoa> pessoas) {
    String pessoasFormatados = pessoas.stream()
        .reduce(new StringBuilder(),
            (modelo, pessoa) -> modelo.append(
                MODELO_PESSOA
                    .replace("COD_PESSOA", pessoa.getCodPessoa().toString())
                    .replace("IMAGEM_PESSOA", pessoa.getImagem())
                    .replace("SEXO_PESSOA", pessoa.getSexo())
                    .replace("PESO_APROXIMADO_PESSOA", pessoa.getPesoAproximado())
                    .replace("COR_PELE_PESSOA", pessoa.getCorPele())
                    .replace("COR_OLHOS_PESSOA", pessoa.getCorOlhos())
                    .replace("DATA_NASCIMENTO_PESSOA", pessoa.getDataNascimento())
                    .replace("NOME_PESSOA", pessoa.getNome())
                    .replace("TIPO_FISICO_PESSOA", pessoa.getTipoFisico())
                    .replace("MARCA_CARACTERISTICA_PESSOA", pessoa.getMarcaCaracteristica())
                    .replace("ALTURA_APROXIMADA_PESSOA", pessoa.getAlturaAproximada())
                    .replace("COR_CABELO_PESSOA", pessoa.getCorCabelo())
                    .replace("TRANSTORNO_MENTAL_PESSOA", pessoa.getTranstornoMental())

            ),
            StringBuilder::append
        ).toString();

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_PESSOAS.replace("Pessoas", pessoasFormatados));
  }

  public String montarSelectDePessoas() {
    return Constantes.PREFIXO + """
        SELECT ?nome ?dataNascimento ?imagem ?sexo ?corOlhos ?corPele 
        ?corCabelo ?tipoFisico ?pesoAproximado ?alturaAproximada ?transtornoMental 
        ?marcaCaracteristica
        WHERE {
          ?pessoa relembrar:nome ?nome . 
          ?pessoa relembrar:dataNascimento ?dataNascimento . 
          ?pessoa relembrar:imagem ?imagem . 
          ?pessoa relembrar:sexo ?sexo . 
          ?pessoa relembrar:corOlhos ?corOlhos . 
          ?pessoa relembrar:corPele ?corPele . 
          ?pessoa relembrar:corCabelo ?corCabelo . 
          ?pessoa relembrar:tipoFisico ?tipoFisico . 
          ?pessoa relembrar:pesoAproximado ?pesoAproximado . 
          ?pessoa relembrar:alturaAproximada ?alturaAproximada . 
          ?pessoa relembrar:transtornoMental ?transtornoMental . 
          ?pessoa relembrar:marcaCaracteristica ?marcaCaracteristica . 
        }""";
  }
}
