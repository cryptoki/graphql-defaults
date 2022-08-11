package de.cryptoki.graphqldefaults

data class GraphQlResponse(val data: Any? = null, val errors: List<GraphQlErrorMessage> = emptyList())
data class GraphQlErrorMessage(val status: Int, val message: String? = null)
