package br.edu.ifba.workbench.testes;

import br.edu.ifba.workbench.modelos.Desaparecimento;

import java.util.List;

public interface ITestador {

  ResultadoTeste testarEscrita(List<Desaparecimento> desaparecimentos);

  ResultadoTeste testarLeitura();

}
