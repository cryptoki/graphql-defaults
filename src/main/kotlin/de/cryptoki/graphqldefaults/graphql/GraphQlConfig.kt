package de.cryptoki.graphqldefaults.graphql

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.extensions.print
import com.expediagroup.graphql.generator.toSchema
import graphql.GraphQL
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQlConfig {

  private val log = LoggerFactory.getLogger(this.javaClass.name)

  @Bean
  fun graphql(
      testQuery: TestQuery
  ): GraphQL {
    val schema = toSchema(
        config = SchemaGeneratorConfig(
            supportedPackages = listOf("de.cryptoki.graphqldefaults.api")
        ),
        queries = listOf(TopLevelObject(testQuery))
    )

    log.info(schema.print())
    return GraphQL.newGraphQL(schema).build()
  }
}
