package br.edu.ifba.workbench.modeladores;

import br.edu.ifba.workbench.modelos.Desaparecimento;
import br.edu.ifba.workbench.utilitarios.Constantes;

import java.util.List;

public class ModeladorRDFDesaparecimentos {

  private static final String MODELO_INSERT_CRIAR_DESAPARECIMENTOS = """
      INSERT DATA {
        Desaparecimentos
      }""";

  private static final String MODELO_DESAPARECIMENTO = """
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:ultimaHoraVista 'ULTIMA_HORA'^^xsd:string . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:informacoes 'INFO'^^xsd:string . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:fonte 'FONTE'^^xsd:string . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:dataDesaparecimento 'DATA_DESAP'^^xsd:string . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:boletimOcorrencia 'BOLETIM'^^xsd:boolean . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:ocorreuEm relembrar:LocalCOD_LOC . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO relembrar:estaAssociado relembrar:PessoaCOD_PESS . 
        relembrar:DesaparecimentoCOD_DESAPARECIMENTO rdf:type relembrar:Desaparecimento . 
      """;

  public String montarInsertDeDesaparecimentos(List<Desaparecimento> desaparecimentos) {
    String desaparecimentosFormatados = desaparecimentos.stream()
        .reduce(new StringBuilder(),
            (modelo, desaparecimento) -> modelo.append(
                MODELO_DESAPARECIMENTO
                    .replace("COD_DESAPARECIMENTO", desaparecimento.getCodDesaparecimento().toString())
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

    return Constantes.PREFIXO + (MODELO_INSERT_CRIAR_DESAPARECIMENTOS.replace("Desaparecimentos", desaparecimentosFormatados));
  }

  public String montarQueryDeDesaparecimentos() {
    return Constantes.PREFIXO + """
        SELECT ?boletimOcorrencia ?informacoes ?dataDesaparecimento ?fonte
          ?ultimaHoraVista ?nome ?dataNascimento ?imagem ?sexo ?corOlhos ?corPele
          ?corCabelo ?tipoFisico ?pesoAproximado ?alturaAproximada ?transtornoMental
          ?marcaCaracteristica ?latitude ?longitude ?nomeBairro ?nomeCidade ?sigla
        WHERE {
          ?cidade ?a ?uf .
          ?cidade relembrar:eCidadeDe ?uf .
          ?bairro ?b ?cidade .
          ?bairro relembrar:eBairroDe ?cidade .
          ?local ?c ?bairro .
          ?local relembrar:eUmPontoDe ?bairro .
          ?desaparecimento ?d ?local .
          ?desaparecimento relembrar:estaAssociado ?pessoa.
          ?desaparecimento relembrar:ocorreuEm ?local.
          ?desaparecimento relembrar:boletimOcorrencia ?boletimOcorrencia .
          ?desaparecimento relembrar:informacoes ?informacoes .
          ?desaparecimento relembrar:dataDesaparecimento ?dataDesaparecimento .
          ?desaparecimento relembrar:fonte ?fonte .
          ?desaparecimento relembrar:ultimaHoraVista ?ultimaHoraVista .
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
          ?local relembrar:latitude ?latitude .
          ?local relembrar:longitude ?longitude .
          ?bairro relembrar:nomeBairro ?nomeBairro .
          ?cidade relembrar:nomeCidade ?nomeCidade .
          ?uf relembrar:sigla ?sigla .
        }""";
  }

  public String montarQueryDeTotalDeDesaparecimentos() {
    return Constantes.PREFIXO + """
        SELECT (count(*) as ?totalDesaparecimentos)
        WHERE {
          ?desaparecimento relembrar:estaAssociado ?pessoa
        }""";
  }
}
