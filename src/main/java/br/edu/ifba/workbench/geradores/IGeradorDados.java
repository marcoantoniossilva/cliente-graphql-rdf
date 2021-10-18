package br.edu.ifba.workbench.geradores;

import br.edu.ifba.workbench.modelos.*;

import java.util.List;

public interface IGeradorDados {

  List<Desaparecimento> gerarDesaparecimentos(int quantidade, int maxCodPessoa, int maxCodLocal);

  List<Uf> gerarUfs();

  List<Cidade> gerarCidades(int quantidade);

  List<Bairro> gerarBairros(int quantidade, int maxCodCidade);

  List<Local> gerarLocais(int quantidade, int maxCodBairro);

  List<Pessoa> gerarPessoas(int quantidade);


}
