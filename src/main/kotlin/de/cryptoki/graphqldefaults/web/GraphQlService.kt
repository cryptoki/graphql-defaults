package de.cryptoki.graphqldefaults.web

import de.cryptoki.graphqldefaults.GraphQlErrorMessage
import de.cryptoki.graphqldefaults.GraphQlRequest
import de.cryptoki.graphqldefaults.GraphQlResponse
import graphql.ExecutionInput
import graphql.GraphQL
import graphql.GraphQLError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.stereotype.Service

@Service
class GraphQlService @Autowired constructor(
    private val graphql: GraphQL
) {

  fun executeGraphQLRequest(request: GraphQlRequest): GraphQlResponse {
    val executionInput = ExecutionInput.newExecutionInput().query(request.query).variables(request.variables ?: emptyMap()).operationName(request.operationName).build()
    val executionResult = graphql.execute(executionInput)
    return GraphQlResponse(executionResult.getData(), getErrors(executionResult.errors))
  }

  private fun getErrors(graphQlErrors: List<GraphQLError?>?): List<GraphQlErrorMessage> {
    return graphQlErrors?.mapNotNull { getErrorMessage(it) } ?: emptyList()
  }

  private fun getErrorMessage(error: GraphQLError?): GraphQlErrorMessage {
    return GraphQlErrorMessage(status = BAD_REQUEST.value(), message = error?.message)
  }
}
