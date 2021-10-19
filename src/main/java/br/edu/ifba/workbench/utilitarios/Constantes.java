package br.edu.ifba.workbench.utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Constantes {

  public static final DateFormat FORMATADOR_DATA = new SimpleDateFormat("yyyy-MM-dd");
  public static final DateFormat FORMATADOR_HORA = new SimpleDateFormat("HH:mm");

  public static final Locale PT_BR_LOCALE = new Locale("pt", "BR");

  public static final String URL_SERVIDOR_GRAPHQL = "http://localhost:4000";
  public static final String URI_ONTOLOGIA_RDF = "src/main/resources/Relembrar.owl";

  public static final String PREFIXO = """
      PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
      PREFIX owl: <http://www.w3.org/2002/07/owl#>
      PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
      PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
      PREFIX relembrar:<http://ontologiarelembrar.github.io/ontologiarelembrar#>
      """;

  public static final String[] FONTES_DISPONIVEIS = {"Mãe", "Pai", "Vizinho", "Tio", "Amigo"};

  public static final String[] SEXOS_DISPONIVEIS = {"M", "F"};

  public static final String[] CORES_PELE_DISPONIVEIS = {"Preto", "Castanho", "Ruivo", "Loiro", "Branco"};
  public static final String[] CORES_OLHOS_DISPONIVEIS = {
      "Azul",
      "Verde",
      "Preto",
      "Castanho",
      "Castanho Claro",
      "Castanho Claro"};
  public static final String[] CORES_CABELOS_DISPONIVEIS = {"Preto", "Castanho", "Ruivo", "Loiro", "Branco"};
  public static final String[] TIPOS_FISICO_DISPONIVEIS = {"Desnutrido", "Normal", "Sobrepeso", "Obeso"};
  public static final String[] TRANSTORNOS_MENTAIS_DISPONIVEIS = {
      "Depressão",
      "Síndrome do pânico",
      "Nenhum",
      "Esquizofrenia"};
  public static final String[] LOCAIS_MARCA_DISPONIVEIS = {
      "perna direita",
      "perna esqueda",
      "braço direito",
      "braço direito"};
  public static final String[] MARCAS_DISPONIVEIS = {"Mancha", "Cicatriz", "Tatuagem"};

  public static class DadosPadrao {
    public static final Integer QTD_BAIRROS_PARA_GERAR = 20000;
    public static final Integer QTD_CIDADES_PARA_GERAR = 5600;
    public static final Integer QTD_LOCAIS_PARA_GERAR = 20000;
    public static final Integer QTD_PESSOAS_PARA_GERAR = 3000;
    public static final Integer QTD_DESAPARECIMENTOS_PARA_GERAR = 3000;
  }

}
