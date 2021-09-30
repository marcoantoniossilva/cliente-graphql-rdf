package br.edu.ifba.workbench.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class GraphQLRequestBody {

  private String operationName;
  private String query;
  private String variables;

  private GraphQLRequestBody() {}

  public static GraphQLRequestBodyBuilder builder() {
    return new GraphQLRequestBodyBuilder();
  }

  public static class GraphQLRequestBodyBuilder {

    private final GraphQLRequestBody graphQLRequestBody;
    private final Gson gson;

    private GraphQLRequestBodyBuilder() {
      this.graphQLRequestBody = new GraphQLRequestBody();
      this.gson = new Gson();
    }

    public GraphQLRequestBodyBuilder operationName(String operationName) {
      this.graphQLRequestBody.operationName = operationName;
      return this;
    }

    public GraphQLRequestBodyBuilder query(String query) {
      this.graphQLRequestBody.query = query;
      return this;
    }

    public GraphQLRequestBodyBuilder variables(Map<String, Object> variables) {
      this.graphQLRequestBody.variables = gson.toJson(variables);
      return this;
    }

    public GraphQLRequestBody build() {
      return graphQLRequestBody;
    }

  }

  @Override
  public String toString() {
    return new GsonBuilder().serializeNulls().create().toJson(this);
  }
}
