package br.edu.ifba.workbench.modelos;

public class Desaparecimento {

  private Integer codDesaparecimento;
  private Integer codPessoa;
  private Integer codLocal;
  private String dataDesaparecimento;
  private String informacoes;
  private String fonte;
  private boolean boletimOcorrencia;
  private String ultimaHoraVista;

  public Integer getCodDesaparecimento() {
    return codDesaparecimento;
  }
  public Desaparecimento setCodDesaparecimento(Integer codDesaparecimento) {
    this.codDesaparecimento = codDesaparecimento;
    return this;
  }

  public Integer getCodPessoa() {
    return codPessoa;
  }
  public Desaparecimento setCodPessoa(Integer codPessoa) {
    this.codPessoa = codPessoa;
    return this;
  }

  public Integer getCodLocal() {
    return codLocal;
  }
  public Desaparecimento setCodLocal(Integer codLocal) {
    this.codLocal = codLocal;
    return this;
  }

  public String getDataDesaparecimento() {
    return dataDesaparecimento;
  }
  public Desaparecimento setDataDesaparecimento(String dataDesaparecimento) {
    this.dataDesaparecimento = dataDesaparecimento;
    return this;
  }

  public String getInformacoes() {
    return informacoes;
  }
  public Desaparecimento setInformacoes(String informacoes) {
    this.informacoes = informacoes;
    return this;
  }

  public String getFonte() {
    return fonte;
  }
  public Desaparecimento setFonte(String fonte) {
    this.fonte = fonte;
    return this;
  }

  public boolean isBoletimOcorrencia() {
    return boletimOcorrencia;
  }
  public Desaparecimento setBoletimOcorrencia(boolean boletimOcorrencia) {
    this.boletimOcorrencia = boletimOcorrencia;
    return this;
  }

  public String getUltimaHoraVista() {
    return ultimaHoraVista;
  }
  public Desaparecimento setUltimaHoraVista(String ultimaHoraVista) {
    this.ultimaHoraVista = ultimaHoraVista;
    return this;
  }

}
