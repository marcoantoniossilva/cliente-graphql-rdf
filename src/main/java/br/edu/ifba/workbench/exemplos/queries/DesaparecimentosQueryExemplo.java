package br.edu.ifba.workbench.exemplos.queries;

import br.edu.ifba.workbench.http.client.ClienteGraphQL;
import br.edu.ifba.workbench.modelos.CorpoRequisicaoGraphQL;

import java.io.IOException;

public class DesaparecimentosQueryExemplo {

  public static void main(String[] args) throws IOException {
    CorpoRequisicaoGraphQL body = CorpoRequisicaoGraphQL.builder()
      .query("""
         query{
            desaparecimentos{
              local{
                bairro{
                  nomeBairro
                }
              }
            }
          }
         """
      )
      .build();

    String response = new ClienteGraphQL("http://localhost:4000").executar(body);
    System.out.println(response);
  }

}
