package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.geradores.IGeradorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.modelos.Desaparecimento;

import java.util.List;

public class Testador implements ITestador {

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
    List<Desaparecimento> desaparecimentos = this.geradorDados.gerarDesaparecimentos(2);

    try {
      this.escritorDados.escrever(desaparecimentos);
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }

    return null;
  }

  @Override
  public ResultadoTeste testarLeitura() {
    return null;
  }

}
