package br.edu.ifba.workbench.http.client;

import br.edu.ifba.workbench.modelos.GraphQLRequestBody;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;

public class GraphQLClient {

  private final URI baseUrl;

  public GraphQLClient(String baseUrl) {
    this.baseUrl = URI.create(baseUrl);
  }

  public String call(GraphQLRequestBody body) throws IOException {
    BasicHttpEntity httpEntity = new BasicHttpEntity();
    httpEntity.setContent(new ByteArrayInputStream(body.toString().getBytes()));

    System.out.printf("Corpo enviado:: %s%n", body.toString());
    HttpPost post = new HttpPost(this.baseUrl);
    post.setHeader("Content-Type", "application/json;charset=UTF-8");
    post.setEntity(httpEntity);

    try (CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse response = httpClient.execute(post)) {

      return EntityUtils.toString(response.getEntity());
    }
  }

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
      .variables(Collections.singletonMap("id", 1))
      .build();

    String response = new GraphQLClient("http://localhost:4000").call(body);
    System.out.println(response);
  }

}
