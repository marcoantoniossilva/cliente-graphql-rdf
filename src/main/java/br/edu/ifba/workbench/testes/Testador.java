package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;

public class Testador implements ITestador {

  @Override
  public ResultadoTeste testarEscrita(IEscritorDados escritorDados) {
    return null;
  }

  @Override
  public ResultadoTeste testarLeitura(ILeitorDados leitorDados) {
    return null;
  }

}
