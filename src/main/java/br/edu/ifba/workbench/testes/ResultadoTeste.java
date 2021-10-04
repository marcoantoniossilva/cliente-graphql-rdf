package br.edu.ifba.workbench.testes;

public class ResultadoTeste {

  private String duracao;

  public String getDuracao() {
    return duracao;
  }
  public ResultadoTeste setDuracao(String duracao) {
    this.duracao = duracao;
    return this;
  }

  @Override
  public String toString() {
    return "ResultadoTeste{duracao='%s'}".formatted(duracao);
  }
}
