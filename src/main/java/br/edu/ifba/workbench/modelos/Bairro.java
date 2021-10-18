package br.edu.ifba.workbench.modelos;

public class Bairro {

  private Integer codBairro;
  private String nomeBairro;
  private Integer codCidade;

  public Integer getCodBairro() {
    return codBairro;
  }

  public Bairro setCodBairro(Integer codBairro) {
    this.codBairro = codBairro;
    return this;
  }

  public String getNomeBairro() {
    return nomeBairro;
  }

  public Bairro setNomeBairro(String nomeBairro) {
    this.nomeBairro = nomeBairro;
    return this;
  }

  public Integer getCodCidade() {
    return codCidade;
  }

  public Bairro setCodCidade(Integer codCidade) {
    this.codCidade = codCidade;
    return this;
  }
}
