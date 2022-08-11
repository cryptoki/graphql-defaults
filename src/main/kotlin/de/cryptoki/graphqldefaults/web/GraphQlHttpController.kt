package de.cryptoki.graphqldefaults.web

import de.cryptoki.graphqldefaults.GraphQlRequest
import de.cryptoki.graphqldefaults.GraphQlResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController

@RestController
class GraphQlController @Autowired constructor(
    private val graphQlService: GraphQlService
) {

  @RequestMapping(
      value = ["/graphql"],
      method = [POST],
      consumes = [APPLICATION_JSON_VALUE],
      produces = [APPLICATION_JSON_VALUE])
  fun angebote(@RequestBody request: GraphQlRequest): GraphQlResponse {
    return graphQlService.executeGraphQLRequest(request)
  }
}
