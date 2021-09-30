package br.edu.ifba.workbench.modelos;

public class GraphQLRequestBody {

  private String query;
  private Object variables;

  private GraphQLRequestBody() {}

  private static GraphQLRequestBodyBuilder builder() {
    return new GraphQLRequestBodyBuilder();
  }

  static class GraphQLRequestBodyBuilder {

    private final GraphQLRequestBody graphQLRequestBody;

    private GraphQLRequestBodyBuilder() {
      this.graphQLRequestBody = new GraphQLRequestBody();
    }

    public GraphQLRequestBodyBuilder query(String query) {
      this.graphQLRequestBody.query = query;
      return this;
    }

    public GraphQLRequestBodyBuilder variables(Object variables) {
      this.graphQLRequestBody.variables = variables;
      return this;
    }

    public GraphQLRequestBody build() {
      return graphQLRequestBody;
    }

  }

}
