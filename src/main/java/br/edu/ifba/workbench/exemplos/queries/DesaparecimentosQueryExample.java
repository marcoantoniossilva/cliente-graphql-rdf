package br.edu.ifba.workbench.exemplos.queries;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.CorpoRequisicaoGraphQL;

import java.io.IOException;
import java.util.Collections;

public class DesaparecimentosQueryExample {

  public static void main(String[] args) throws IOException {
    CorpoRequisicaoGraphQL body = CorpoRequisicaoGraphQL.builder()
      .query("""
         query($id: Int) {
           desaparecimento(filtro: { codDesaparecimento: $id }) {
             boletimOcorrencia
             informacoes
             pessoa{
              nome
               dataNascimento
               imagem
             }
             local{
               latitude
               longitude
               bairro{
                 nomeBairro
                 cidade{
                   nomeCidade
                   uf{
                     sigla
                   }
                 }
               }
             }
           }
         }
         """
      )
      .variables(Collections.singletonMap("id", 8888))
      .build();

    String response = new ClienteGraphQL("http://localhost:4000").executar(body);
    System.out.println(response);
  }

}
