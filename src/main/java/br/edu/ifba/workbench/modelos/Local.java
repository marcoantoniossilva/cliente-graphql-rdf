package br.edu.ifba.workbench.modelos;

public class Local {

  private Integer codLocal;
  private Integer codBairro;
  private String latitude;
  private String longitude;

  public Integer getCodLocal() {
    return codLocal;
  }

  public Local setCodLocal(Integer codLocal) {
    this.codLocal = codLocal;
    return this;
  }

  public Integer getCodBairro() {
    return codBairro;
  }

  public Local setCodBairro(Integer codBairro) {
    this.codBairro = codBairro;
    return this;
  }

  public String getLatitude() {
    return latitude;
  }

  public Local setLatitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

  public String getLongitude() {
    return longitude;
  }

  public Local setLongitude(String longitude) {
    this.longitude = longitude;
    return this;
  }
}
