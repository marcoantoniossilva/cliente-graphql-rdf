package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.escritores.IEscritorDados;
import br.edu.ifba.workbench.leitores.ILeitorDados;
import br.edu.ifba.workbench.testes.impl.ResultadoTeste;

public interface ITestes {

  ResultadoTeste testarEscrita(IEscritorDados escritorDados);
  ResultadoTeste testarLeitura(ILeitorDados leitorDados);

}
