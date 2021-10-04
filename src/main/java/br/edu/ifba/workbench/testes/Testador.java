package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.modelos.Desaparecimento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Testador implements ITestador {

  private static final Logger LOGGER = LoggerFactory.getLogger(Testador.class);

  private final IEscritorDados escritorDados;
  private final ILeitorDados leitorDados;
  private final IGeradorDados geradorDados;

  public Testador(IEscritorDados escritorDados, ILeitorDados leitorDados, IGeradorDados geradorDados) {
    this.escritorDados = escritorDados;
    this.leitorDados = leitorDados;
    this.geradorDados = geradorDados;
  }

  @Override
  public ResultadoTeste testarEscrita() {
    try {
      List<Desaparecimento> desaparecimentos = this.geradorDados.gerarDesaparecimentos(2);

      long tempoInicial = System.currentTimeMillis();
      this.escritorDados.escrever(desaparecimentos);
      long duracaoEmMilisegundos = System.currentTimeMillis() - tempoInicial;

      String duracaoTeste = "%d Milisegundos".formatted(duracaoEmMilisegundos);
      return ResultadoTeste.sucesso(duracaoTeste);
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage(), exception);
      return ResultadoTeste.falha();
    }
  }

  @Override
  public ResultadoTeste testarLeitura() {
    try {
      long tempoInicial = System.currentTimeMillis();
      this.leitorDados.ler();
      long duracaoEmMilisegundos = System.currentTimeMillis() - tempoInicial;

      String duracaoTeste = "%d Milisegundos".formatted(duracaoEmMilisegundos);
      return ResultadoTeste.sucesso(duracaoTeste);
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage(), exception);
      return ResultadoTeste.falha();
    }
  }

}
