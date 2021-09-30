package br.edu.ifba.workbench.exemplos.mutations;

import br.edu.ifba.workbench.http.client.GraphQLClient;
import br.edu.ifba.workbench.modelos.GraphQLRequestBody;

import java.io.IOException;

public class DesaparecimentosMutationExample {

  public static void main(String[] args) throws IOException {
    GraphQLRequestBody body = GraphQLRequestBody.builder()
      .query("""
         mutation {
           criarDesaparecimentos(
             data: [
               {
                 codDesaparecimento: 5004
                 codPessoa: 52
                 codLocal: 45
                 dataDesaparecimento: "2020-05-01"
                 informacoes: "Informações Teste"
                 fonte: "Dados informados pelo pai"
                 boletimOcorrencia: true
                 ultimaHoraVista: "17:45"
               }
               {
                 codDesaparecimento: 5005
                 codPessoa: 52
                 codLocal: 45
                 dataDesaparecimento: "2020-05-01"
                 informacoes: "Informações Teste"
                 fonte: "Dados informados pelo pai"
                 boletimOcorrencia: true
                 ultimaHoraVista: "17:45"
               }
             ]
           ) {
             codDesaparecimento
           }
         }
         """
      )
      .build();

    String response = new GraphQLClient("http://localhost:4000").call(body);
    System.out.println(response);
  }


}
