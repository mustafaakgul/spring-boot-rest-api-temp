## Best Practices
* https://dev.to/jazzybruno/spring-boot-project-folder-structure-12oe
* https://www.javatpoint.com/spring-boot-architecture
* https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
* https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819

* Use properties files for all static string in the project. For instance CrossOrigin(origins = "${cross.origin.url}") instead of CrossOrigin(origins = "http://localhost:4200")

## Architecture
* Presentation Layer
  * Authentication
  * JSON Transformation
* Business Layer
  * Business Logic
  * Validation
  * Authorization
* Persistence Layer
  * Storage Logic
* Database Layer
  * Actual Database

## Structure

## Naming Conventions