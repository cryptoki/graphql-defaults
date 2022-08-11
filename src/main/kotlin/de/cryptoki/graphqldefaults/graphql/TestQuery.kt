package de.cryptoki.graphqldefaults.graphql

import de.cryptoki.graphqldefaults.api.SomeRequest
import de.cryptoki.graphqldefaults.api.SomeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestQuery @Autowired constructor() {

  fun testing(request: SomeRequest): SomeResponse {
    return SomeResponse(request.value ?: 100)
  }
}
