package br.edu.ifba.workbench.leitores;

import br.edu.ifba.workbench.modeladores.ModeladorRDFDesaparecimentos;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class LeitorRDF implements ILeitorDados {

  private static final Logger LOGGER = LoggerFactory.getLogger(LeitorRDF.class);

  private final ModeladorRDFDesaparecimentos modeladorRDF;
  private final OntModel modelo;

  public LeitorRDF(String uriOntologiaRDF) {
    this.modelo = (OntModel) ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM).read(new File(uriOntologiaRDF).toURI().toString());
    this.modeladorRDF = new ModeladorRDFDesaparecimentos();
  }

  @Override
  public void ler() throws IOException {
    String queryDeDesaparecimentos = this.modeladorRDF.montarQueryDeDesaparecimentos();

    Query query = QueryFactory.create(queryDeDesaparecimentos);
    QueryExecution queryExecution = QueryExecutionFactory.create(query, modelo);
    ResultSet results = queryExecution.execSelect();

    try (OutputStream respostaSPARQL = new ByteArrayOutputStream()) {
      ResultSetFormatter.out(respostaSPARQL, results, query);

      queryExecution.close();
      LOGGER.info("Resposta do SPARQL para chamada de leitura de desaparecimentos: {}", respostaSPARQL);
    }
  }
}
