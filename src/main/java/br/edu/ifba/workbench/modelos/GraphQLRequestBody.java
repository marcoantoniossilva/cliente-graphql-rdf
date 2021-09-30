package br.edu.ifba.workbench.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GraphQLRequestBody {

  private String operationName;
  private String query;
  private String variables = "{}";

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
      this.graphQLRequestBody.variables = gson.toJson(Objects.nonNull(variables) ? variables : new HashMap<>());
      return this;
    }

    public GraphQLRequestBody build() {
      if (Objects.isNull(this.graphQLRequestBody.variables)) {
        this.graphQLRequestBody.variables = gson.toJson(new HashMap<>());
      }
      return graphQLRequestBody;
    }

  }

  @Override
  public String toString() {
    return new GsonBuilder().serializeNulls().create().toJson(this);
  }
}
