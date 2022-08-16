import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.2"
  id("io.spring.dependency-management") version "1.0.12.RELEASE"
  kotlin("jvm") version "1.7.10"
  kotlin("plugin.spring") version "1.7.10"
}

group = "de.cryptoki"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.google.code.findbugs:jsr305:3.0.2")
  implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains:annotations:23.0.0")
  implementation("javax.annotation:javax.annotation-api:1.3.2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  implementation("com.expediagroup:graphql-kotlin-schema-generator:6.0.0-SNAPSHOT")
  implementation("com.graphql-java:graphql-java-extended-scalars:18.1")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
