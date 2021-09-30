package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.Desaparecimento;

import java.util.List;

public interface IGeradorDados {

  default Desaparecimento gerarDesaparecimento() {
    return this.gerarDesaparecimentos(1).iterator().next();
  }

  List<Desaparecimento> gerarDesaparecimentos(int quantidade);

}
