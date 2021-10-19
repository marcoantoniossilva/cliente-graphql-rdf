package br.edu.ifba.workbench.modelos;

public class Pessoa {

  private Integer codPessoa;
  private String imagem;
  private String sexo;
  private Float pesoAproximado;
  private String corPele;
  private String corOlhos;
  private String dataNascimento;
  private String nome;
  private String tipoFisico;
  private String marcaCaracteristica;
  private Float alturaAproximada;
  private String corCabelo;
  private String transtornoMental;

  public Integer getCodPessoa() {
    return codPessoa;
  }

  public Pessoa setCodPessoa(Integer codPessoa) {
    this.codPessoa = codPessoa;
    return this;
  }

  public String getImagem() {
    return imagem;
  }

  public Pessoa setImagem(String imagem) {
    this.imagem = imagem;
    return this;
  }

  public String getSexo() {
    return sexo;
  }

  public Pessoa setSexo(String sexo) {
    this.sexo = sexo;
    return this;
  }

  public Float getPesoAproximado() {
    return pesoAproximado;
  }

  public Pessoa setPesoAproximado(Float pesoAproximado) {
    this.pesoAproximado = pesoAproximado;
    return this;
  }

  public String getCorPele() {
    return corPele;
  }

  public Pessoa setCorPele(String corPele) {
    this.corPele = corPele;
    return this;
  }

  public String getCorOlhos() {
    return corOlhos;
  }

  public Pessoa setCorOlhos(String corOlhos) {
    this.corOlhos = corOlhos;
    return this;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public Pessoa setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public Pessoa setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getTipoFisico() {
    return tipoFisico;
  }

  public Pessoa setTipoFisico(String tipoFisico) {
    this.tipoFisico = tipoFisico;
    return this;
  }

  public String getMarcaCaracteristica() {
    return marcaCaracteristica;
  }

  public Pessoa setMarcaCaracteristica(String marcaCaracteristica) {
    this.marcaCaracteristica = marcaCaracteristica;
    return this;
  }

  public Float getAlturaAproximada() {
    return alturaAproximada;
  }

  public Pessoa setAlturaAproximada(Float alturaAproximada) {
    this.alturaAproximada = alturaAproximada;
    return this;
  }

  public String getCorCabelo() {
    return corCabelo;
  }

  public Pessoa setCorCabelo(String corCabelo) {
    this.corCabelo = corCabelo;
    return this;
  }

  public String getTranstornoMental() {
    return transtornoMental;
  }

  public Pessoa setTranstornoMental(String transtornoMental) {
    this.transtornoMental = transtornoMental;
    return this;
  }
}
