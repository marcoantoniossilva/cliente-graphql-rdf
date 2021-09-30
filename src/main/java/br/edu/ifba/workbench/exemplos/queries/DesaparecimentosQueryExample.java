package br.edu.ifba.workbench.exemplos.queries;

import br.edu.ifba.workbench.http.client.GraphQLClient;
import br.edu.ifba.workbench.modelos.GraphQLRequestBody;

import java.io.IOException;
import java.util.Collections;

public class DesaparecimentosQueryExample {

  public static void main(String[] args) throws IOException {
    GraphQLRequestBody body = GraphQLRequestBody.builder()
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

    String response = new GraphQLClient("http://localhost:4000").call(body);
    System.out.println(response);
  }

}
