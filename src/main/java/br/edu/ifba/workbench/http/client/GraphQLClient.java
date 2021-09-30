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

public class GraphQLClient {

  private final URI baseUrl;

  public GraphQLClient(String baseUrl) {
    this.baseUrl = URI.create(baseUrl);
  }

  public String call(GraphQLRequestBody body) throws IOException {
    BasicHttpEntity httpEntity = new BasicHttpEntity();
    httpEntity.setContent(new ByteArrayInputStream(body.toString().getBytes()));

    HttpPost post = new HttpPost(this.baseUrl);
    post.setHeader("Content-Type", "application/json;charset=UTF-8");
    post.setEntity(httpEntity);

    try (CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse response = httpClient.execute(post)) {
      return EntityUtils.toString(response.getEntity());
    }
  }

}
