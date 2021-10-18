package br.edu.ifba.workbench.escritores;

import br.edu.ifba.workbench.modelos.*;

import java.io.IOException;
import java.util.List;

public interface IEscritorDados {

  void escreverDesaparecimentos(List<Desaparecimento> desaparecimentos) throws IOException;

  void escreverUfs(List<Uf> ufs) throws IOException;

  void escreverCidades(List<Cidade> cidades) throws IOException;

  void escreverBairros(List<Bairro> bairros) throws IOException;

  void escreverLocais(List<Local> locais) throws IOException;

  void escreverPessoas(List<Pessoa> pessoas) throws IOException;

}
