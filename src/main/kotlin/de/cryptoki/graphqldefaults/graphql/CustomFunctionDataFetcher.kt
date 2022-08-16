package de.cryptoki.graphqldefaults.graphql

import com.expediagroup.graphql.generator.execution.FunctionDataFetcher
import com.expediagroup.graphql.generator.execution.SimpleKotlinDataFetcherFactoryProvider
import com.fasterxml.jackson.databind.ObjectMapper
import graphql.schema.DataFetcherFactory
import kotlin.reflect.KFunction

class CustomFunctionDataFetcher(
    private val target: Any?,
    private val fn: KFunction<*>,
) : FunctionDataFetcher(target, fn) {

  val objectMapper: ObjectMapper = ObjectMapper()
  override fun mapToJavaObject(arguments: Map<String, *>, clazz: Class<*>): Any? =
    objectMapper.convertValue(arguments, clazz)
}

class CustomKotlinDataFetcherFactoryProvider : SimpleKotlinDataFetcherFactoryProvider() {

  override fun functionDataFetcherFactory(target: Any?, kFunction: KFunction<*>) = DataFetcherFactory {
    CustomFunctionDataFetcher(
        target = target,
        fn = kFunction
    )
  }
}
