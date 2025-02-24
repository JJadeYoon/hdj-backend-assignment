plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.25"
	kotlin("kapt") version "1.9.25"
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
}

group = "com.hdj"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

configurations {
	create("asciidoctorExt")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// asciidoctor
	"asciidoctorExt"("org.springframework.restdocs:spring-restdocs-asciidoctor")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

	//querydsl
	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}

kotlin {
	jvmToolchain(17)
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

val snippetsDir by extra { file("build/generated-snippets") }

tasks.test {
	outputs.dir(snippetsDir)
	useJUnitPlatform()
}

tasks.asciidoctor {
	dependsOn(tasks.test)
	configurations("asciidoctorExt")
	inputs.dir(snippetsDir)

	baseDirFollowsSourceFile()
}

tasks.bootJar {
	dependsOn(tasks.asciidoctor)
	from("${tasks.asciidoctor.get().outputDir}/html5") {
		into("static/docs")
	}
}

tasks.register<Copy>("copyDocument") {
	dependsOn(tasks.asciidoctor)
	from(file("build/docs/asciidoc"))
	into(file("src/main/resources/static/docs"))
}

tasks.build {
	dependsOn("copyDocument")
}