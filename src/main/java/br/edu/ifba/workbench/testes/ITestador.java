package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;

public interface ITestador {

  ResultadoTeste testarEscrita(IEscritorDados escritorDados);
  ResultadoTeste testarLeitura(ILeitorDados leitorDados);

}