package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.Desaparecimento;

import java.util.Arrays;
import java.util.List;

public class FakerGeradorDados implements IGeradorDados {

  @Override
  public List<Desaparecimento> gerarDesaparecimentos(int quantidade) {
    return Arrays.asList(
      new Desaparecimento()
        .setCodDesaparecimento(5006)
        .setCodPessoa(52)
        .setCodLocal(45)
        .setDataDesaparecimento("2020-05-01")
        .setInformacoes("Informações teste java")
        .setFonte("Fonte do teste Java")
        .setBoletimOcorrencia(true)
        .setUltimaHoraVista("17:45"),
      new Desaparecimento()
        .setCodDesaparecimento(5007)
        .setCodPessoa(52)
        .setCodLocal(45)
        .setDataDesaparecimento("2020-05-01")
        .setInformacoes("Informações teste java 2")
        .setFonte("Fonte do teste Java 2")
        .setBoletimOcorrencia(false)
        .setUltimaHoraVista("17:45")
    );
  }

}
