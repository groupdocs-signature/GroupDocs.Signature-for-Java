# GroupDocs.Signature for Java - Demos

Demo projects showcasing [GroupDocs.Signature for Java](https://products.groupdocs.com/signature/java) with different frameworks.

All web demos run on `http://localhost:8080/signature/` and provide document signing with digital certificates, images, text, stamps, barcodes, and QR codes.

> **Demo only — not for production use.** Web demos in this folder illustrate GroupDocs.Signature API capabilities. They lack production-grade security controls. Use them locally for evaluation and build your own hardened service for deployment.

| Demo | Framework | Language | Run command |
|------|-----------|----------|-------------|
| [Spring](Spring) | Spring Boot 2.5 | Java | `mvn clean spring-boot:run` |
| [Dropwizard](Dropwizard) | Dropwizard 1.3 | Java | `mvn clean compile exec:java` |
| [Javalin](Javalin) | Javalin 4.6 | Kotlin | `./gradlew run` |
| [Ktor](Ktor) | Ktor | Kotlin | `./gradlew run` |
| [Micronaut](Micronaut) | Micronaut 3.4 | Kotlin | `./gradlew run` |
| [Compose](Compose) | Compose Desktop | Kotlin | `./gradlew run` |

The [Compose](Compose) demo is a standalone desktop application (not a web app).

See the [main README](../README.md) for Docker images and getting started instructions.
