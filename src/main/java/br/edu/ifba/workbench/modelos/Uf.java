package br.edu.ifba.workbench.modelos;

public class Uf {

  private Integer codUf;
  private String sigla;

  public Uf(Integer codUf, String sigla) {
    this.codUf = codUf;
    this.sigla = sigla;
  }

  public Integer getCodUf() {
    return codUf;
  }

  public Uf setCodUf(Integer codUf) {
    this.codUf = codUf;
    return this;
  }

  public String getSigla() {
    return sigla;
  }

  public Uf setSigla(String sigla) {
    this.sigla = sigla;
    return this;
  }
}
