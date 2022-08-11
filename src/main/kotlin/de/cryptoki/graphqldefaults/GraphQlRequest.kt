package de.cryptoki.graphqldefaults

data class GraphQlRequest(val query: String = "", val variables: Map<String, Any>? = emptyMap(), val operationName: String? = null)
