plugins {
	java
	id("org.springframework.boot") version "3.2.11"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.jibs"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.hsqldb:hsqldb:2.7.2")
	// Banco de dados
//	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.oracle.database.jdbc:ojdbc11")

	// Dependência do MapStruct
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.hibernate.orm:hibernate-core:6.4.10.Final")

	// Dependência do processor do MapStruct
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
