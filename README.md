# Spring Boot REST API template for rapid project setup
## Best Practices
* https://medium.com/javarevisited/10-spring-boot-best-practices-to-learn-in-10-minutes-b4ea307b2a84
* https://dev.to/jazzybruno/spring-boot-project-folder-structure-12oe
* https://www.javatpoint.com/spring-boot-architecture
* https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
* https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819
* Use POJOs (Plain Old Java Objects) for data transfer objects (DTOs) and entities.
* Use wrapper classes for fundamental data types (e.g., Integer instead of int).
* BigDecimal for monetary values instead of double or float in FinTech.
* Use Health Check for application health monitoring. Spring Boot Actuator provides endpoints for health checks.
* Metrics Collection: Use Micrometer for collecting application metrics.
* Structured Logging: Use a structured logging framework. Application and physical logs like cpu.
* Monitoring Setup: Use Prometheus and Grafana for monitoring and visualization.
* Use properties files for all static string in the project. For instance CrossOrigin(origins = "${cross.origin.url}") instead of CrossOrigin(origins = "http://localhost:4200")
* Do not use @Autowired annotation for constructor injection. Use constructor directly.
* Do not use wildcard imports.
* Use command + shift + N to create scratch files in IntelliJ IDEA like properties, json, HTTP request, etc.
* Database Naming Conventions:
  * Table Names: snake_case and plural (e.g., user_accounts)
  * Column Names: snake_case and singular (e.g., first_name)
  * https://blog.api-fiddle.com/posts/naming-conventions-in-postgresql
  * https://www.geeksforgeeks.org/postgresql/postgresql-naming-conventions/
* HTTP Status Codes: https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status#client_error_responses
* HTTP Methods:
  * GET: Retrieve data
  * POST: Create new resource
  * PUT: Update existing resource
  * PATCH: Partially update existing resource, small changes in big resource (data)
  * DELETE: Remove resource
* HOW MUCH REST API: Richardson Maturity Model (0 to 3 - worst to best)
  * Level 0: Swamp of POX: Single Endpoint, Uses HTTP as tunnel, Soap over HTTP ("There's a single service that determines what to do based on the contents of the payload)
  * Level 1: Resources: Multiple Endpoints, Single HTTP Method like Everything works over POST, Ex: /users/1234
  * Level 2: HTTP Methods (Verbs): Proper use of HTTP methods, Status Codes, Ex: GET /users/123
  * Level 3: Hypermedia Controls: HATEOAS: Hypermedia controls, Self-discovering API, Ex: Links in responses
* Production Best Practices: 
  * Use HTTPS
  * Implement Rate Limiting: API Gateway to Centralize or Custom Middleware
  * Proper Error Handling: Controller Advice and Global Exception Handling (Controller Advice Uygun Modulde Yakalıyor ve Ona Gore Mesaj Donuyor, Her Yerde try catch Kullanıma Gerek Kalmıyor)
  * Use Caching: @Cacheable, @CacheEvict, @CachePut That Provider Memory Saving etc.
  * Implement Pagination
  * Use API Versioning: URL Versioning or Header Versioning
  * Secure Sensitive Data
  * Use Environment Variables for Configuration
  * Implement Logging and Comprehensive Monitoring
  * Use Circuit Breaker Pattern for Resilience
  * Automated Testing
  * Security at all Levels,
  * Performance Optimation: Cache, Database Indexing, Asynchronous Processing, etc.
* Scability Patterns:
  * Load Balancing: Distribute incoming requests across multiple instances.
  * Horizontal Scaling: Add more instances to handle increased load.
  * Vertical Scaling: Increase resources (CPU, RAM) of existing instances.
  * Caching Strategies: Use in-memory caches like Redis or Memcached to reduce database load.
  * Asynchronous Processing: Use message queues (e.g., RabbitMQ, Kafka) for background processing.
  * Database Sharding: Split large databases into smaller, more manageable pieces.
* Security Best Practices:
  * Use HTTPS for secure communication.
  * Implement JWT Authentication for stateless sessions.
  * Use OAuth2 for third-party integrations.
  * Validate and sanitize all user inputs to prevent SQL injection and XSS attacks.
  * Implement Role-Based Access Control (RBAC) for authorization.
  * Regularly update dependencies to patch vulnerabilities.
  * Use environment variables for sensitive configurations.
  * Monitor application logs for suspicious activities.
  * Authentication and Authorization.
  * Data Encryption, Do not store sensitive data in plain text in DBs, use Vaults or Encryption Libraries.
  * API Gateway for Centralized Security.
  * Input Validation and Sanitization.
  * Error Handling
* Monitoring Strategies: Application metrics, infrastructure monitoring, log aggregation, tracing, alerting.
  * Use Prometheus for metrics collection.
  * Use Grafana for visualization of metrics.
  * Set up alerts for critical metrics (e.g., error rates, response times).
  * Use distributed tracing tools like Jaeger or Zipkin for performance monitoring.
  * Log aggregation with tools like ELK Stack (Elasticsearch, Logstash, Kibana) or Fluentd.
* Documentation Best Practices:
  * Use OpenAPI Specification (OAS) for API documentation.
  * Generate API documentation using Swagger or Spring REST Docs.
  * Keep documentation up-to-date with code changes.
  * Provide examples for API endpoints.
  * Document error responses and status codes.
  * Use Markdown for README files and project documentation.
  * Technical Documentation: AI or Human Generated.
  * User Guides
  * Inline Code Documentation: Javadoc for Java code.
  * Change Logs

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

## Technical Stack
* Java
* Maven
* Spring Framework
* Spring Boot 3.x
* Spring Data JPA
* Spring Security
* Spring Web
* Spring Boot Actuator
* Spring Cloud
* System Design
* DevOps
* Git
* Unit Testing for Every Unit: JUnit, Mockito
* Integration Testing: Correlation Test Between Components
* Container Testing: Test Containers
* RESTful Web Services: Stateless, Resource-Oriented, Uniform Interface, Standard HTTP
* Event: Kafka
* Queue: RabbitMQ
* Containerization: Docker
* API Documentation: Swagger
* Monitoring: Prometheus, Grafana
* Security: JWT Authentication, OAuth(2)
* CI/CD: GitHub Actions
* Database: PostgreSQL
* ORM: Hibernate
* Kubernetes
* Architecture: Microservices, Monolith
* Cloud Platforms: AWS, Heroku, DigitalOcean
* OpenAPI Specification

## Structure

## Naming Conventions
