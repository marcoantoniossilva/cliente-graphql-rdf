package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.modelos.Desaparecimento;

import java.io.IOException;
import java.util.List;

public interface IEscritorDados {

  void escrever(List<Desaparecimento> desaparecimentos) throws IOException;

}
