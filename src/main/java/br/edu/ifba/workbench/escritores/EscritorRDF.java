package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.modeladores.*;
import br.edu.ifba.workbench.modelos.*;
import br.edu.ifba.workbench.utilitarios.Constantes;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.update.UpdateAction;
import com.hp.hpl.jena.update.UpdateFactory;
import com.hp.hpl.jena.update.UpdateRequest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EscritorRDF implements IEscritorDados {

  private final ModeladorRDFDesaparecimentos modeladorRDFDesaparecimentos;
  private final ModeladorRDFUfs modeladorRDFUfs;
  private final ModeladorRDFCidades modeladorRDFCidade;
  private final ModeladorRDFBairros modeladorRDFBairro;
  private final ModeladorRDFLocais modeladorRDFLocais;
  private final ModeladorRDFPessoas modeladorRDFPessoas;
  private final OntModel modelo;

  public EscritorRDF(String uriOntologiaRDF) {
    this.modelo = (OntModel) ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM).read(new File(uriOntologiaRDF).toURI().toString());

    this.modeladorRDFDesaparecimentos = new ModeladorRDFDesaparecimentos();
    this.modeladorRDFUfs = new ModeladorRDFUfs();
    this.modeladorRDFCidade = new ModeladorRDFCidades();
    this.modeladorRDFBairro = new ModeladorRDFBairros();
    this.modeladorRDFLocais = new ModeladorRDFLocais();
    this.modeladorRDFPessoas = new ModeladorRDFPessoas();
  }

  @Override
  public void escreverDesaparecimentos(List<Desaparecimento> desaparecimentos) throws IOException {
    String insert = this.modeladorRDFDesaparecimentos.montarInsertDeDesaparecimentos(desaparecimentos);

    chamarEscritaRdf(insert);
  }

  @Override
  public void escreverUfs(List<Uf> ufs) throws IOException {
    String insert = this.modeladorRDFUfs.montarInsertDeUfs(ufs);

    chamarEscritaRdf(insert);
  }

  @Override
  public void escreverCidades(List<Cidade> cidades) throws IOException {
    String insert = this.modeladorRDFCidade.montarInsertDeCidades(cidades);

    chamarEscritaRdf(insert);
  }

  @Override
  public void escreverBairros(List<Bairro> bairros) throws IOException {
    String insert = this.modeladorRDFBairro.montarInsertDeBairros(bairros);

    chamarEscritaRdf(insert);
  }

  @Override
  public void escreverLocais(List<Local> locais) throws IOException {
    String insert = this.modeladorRDFLocais.montarInsertDeLocais(locais);

    chamarEscritaRdf(insert);
  }

  @Override
  public void escreverPessoas(List<Pessoa> pessoas) throws IOException {
    String insert = this.modeladorRDFPessoas.montarInsertDePessoas(pessoas);

    chamarEscritaRdf(insert);
  }

  public void chamarEscritaRdf(String insert) throws IOException {
    UpdateRequest request = UpdateFactory.create(insert);
    UpdateAction.execute(request, modelo);
    modelo.write(new PrintWriter(Constantes.URI_ONTOLOGIA_RDF));
  }

}
