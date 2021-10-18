package br.edu.ifba.workbench.modelos;

public class Cidade {

  private Integer codCidade;
  private String nomeCidade;
  private Integer codUf;

  public Integer getCodCidade() {
    return codCidade;
  }

  public Cidade setCodCidade(Integer codCidade) {
    this.codCidade = codCidade;
    return this;
  }

  public String getNomeCidade() {
    return nomeCidade;
  }

  public Cidade setNomeCidade(String nomeCidade) {
    this.nomeCidade = nomeCidade;
    return this;
  }

  public Integer getCodUf() {
    return codUf;
  }

  public Cidade setCodUf(Integer codUf) {
    this.codUf = codUf;
    return this;
  }
}
