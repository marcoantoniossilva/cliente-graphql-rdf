package br.edu.ifba.workbench.testes;

public class ResultadoTeste {

  private String duracao;
  private boolean sucesso;

  public String getDuracao() {
    return duracao;
  }
  private ResultadoTeste setDuracao(String duracao) {
    this.duracao = duracao;
    return this;
  }

  public boolean isSucesso() {
    return sucesso;
  }
  private ResultadoTeste setSucesso(boolean sucesso) {
    this.sucesso = sucesso;
    return this;
  }

  public static ResultadoTeste falha() {
    return new ResultadoTeste().setSucesso(false);
  }

  public static ResultadoTeste sucesso(String duracao) {
    return new ResultadoTeste().setSucesso(true).setDuracao(duracao);
  }

  @Override
  public String toString() {
    return "ResultadoTeste{duracao='%s', sucesso=%s}".formatted(duracao, sucesso);
  }
}
