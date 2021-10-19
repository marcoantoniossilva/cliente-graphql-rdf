package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.modelos.*;
import br.edu.ifba.workbench.utilitarios.Constantes.DadosPadrao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Povoador {

  private static final Logger LOGGER = LoggerFactory.getLogger(Povoador.class);

  private final IGeradorDados geradorDados;
  private final List<IEscritorDados> escritoresDados;


  public Povoador(IGeradorDados geradorDados, IEscritorDados... escritoresDados) {
    this.geradorDados = geradorDados;
    this.escritoresDados = Arrays.asList(escritoresDados);

  }

  public void povoarDadosPadrao() {
    try {
      List<Uf> ufs = geradorDados.gerarUfs();
      List<Cidade> cidades = geradorDados.gerarCidades(DadosPadrao.QTD_CIDADES_PARA_GERAR);
      List<Bairro> bairros = geradorDados.gerarBairros(DadosPadrao.QTD_BAIRROS_PARA_GERAR, DadosPadrao.QTD_CIDADES_PARA_GERAR);
      List<Local> locais = geradorDados.gerarLocais(DadosPadrao.QTD_LOCAIS_PARA_GERAR, DadosPadrao.QTD_BAIRROS_PARA_GERAR);
      List<Pessoa> pessoas = geradorDados.gerarPessoas(DadosPadrao.QTD_PESSOAS_PARA_GERAR);

      for (IEscritorDados escritorDados : escritoresDados) {
        escritorDados.escreverUfs(ufs);
        escritorDados.escreverCidades(cidades);
        escritorDados.escreverBairros(bairros);
        escritorDados.escreverLocais(locais);
        escritorDados.escreverPessoas(pessoas);
      }
    } catch (IOException exception) {
      LOGGER.error(exception.getMessage(), exception);
    }

  }
}
