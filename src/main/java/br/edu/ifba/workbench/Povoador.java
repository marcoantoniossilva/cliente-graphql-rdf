package br.edu.ifba.workbench;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.testes.Testador;
import br.edu.ifba.workbench.utilitarios.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Povoador {

  private static final Logger LOGGER = LoggerFactory.getLogger(Testador.class);

  private final IEscritorDados escritorDados;
  private final IGeradorDados geradorDados;

  public Povoador(IEscritorDados escritorDados, IGeradorDados geradorDados) {
    this.escritorDados = escritorDados;
    this.geradorDados = geradorDados;
  }

  public void povoarDados() {
    try {
      this.escritorDados.escreverUfs(this.geradorDados.gerarUfs());
      LOGGER.info("Escrito todas as Ufs: {}");
      this.escritorDados.escreverCidades(this.geradorDados.gerarCidades(Constantes.qtdCidadesParaGerar));
      LOGGER.info("Escrito Cidades: {}", Constantes.qtdCidadesParaGerar);
      this.escritorDados.escreverBairros(this.geradorDados.gerarBairros(Constantes.qtdBairrosParaGerar, Constantes.qtdCidadesParaGerar));
      LOGGER.info("Escrito Bairros: {}", Constantes.qtdBairrosParaGerar);
      this.escritorDados.escreverLocais(this.geradorDados.gerarLocais(Constantes.qtdLocaisParaGerar, Constantes.qtdBairrosParaGerar));
      LOGGER.info("Escrito Locais: {}", Constantes.qtdLocaisParaGerar);
      this.escritorDados.escreverPessoas(this.geradorDados.gerarPessoas(Constantes.qtdPessoasParaGerar));
      LOGGER.info("Escrito Pessoas: {}", Constantes.qtdPessoasParaGerar);
    } catch (IOException exception) {
      LOGGER.error(exception.getMessage(), exception);
    }

  }
}
