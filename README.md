# BookStore-Microservice-Project

A BookStore application built using Spring Boot, Spring Cloud, and Docker.

## BookStore Microservices Architecture

### Modules

#### Catalog Service
- Purpose: Provides REST API for managing catalog of products (books)
- Tech Stack: Spring Boot, Spring Data JPA, PostgreSQL

#### Order Service
- Purpose: Provides REST API for managing orders and publishes order events
- Tech Stack: Spring Boot, Spring Security OAuth2, Keycloak, Spring Data JPA, PostgreSQL, RabbitMQ

#### Notification Service
- Purpose: Listens to order events and sends notifications to users
- Tech Stack: Spring Boot, RabbitMQ

#### API Gateway
- Purpose: API Gateway to internal backend services (catalog-service, order-service)
- Tech Stack: Spring Boot, Spring Cloud Gateway

#### Bookstore WebApp
- Purpose: Customer-facing web application for browsing catalog, placing orders, and viewing order details
- Tech Stack: Spring Boot, Spring Security OAuth2, Keycloak, Thymeleaf, Alpine.js, Bootstrap

## Learning Objectives

- Building Spring Boot REST APIs
- Database Persistence using Spring Data JPA, Postgres, Flyway
- Event Driven Async Communication using RabbitMQ
- Implementing OAuth2-based Security using Spring Security and Keycloak
- Implementing API Gateway using Spring Cloud Gateway
- Implementing Resiliency using Resilience4j
- Job Scheduling with ShedLock-based distributed Locking
- Using RestClient, Declarative HTTP Interfaces to invoke other APIs
- Creating Aggregated Swagger Documentation at API Gateway
- Local Development Setup using Docker, Docker Compose, and Testcontainers
- Testing using JUnit 5, RestAssured, Testcontainers, Availability, WireMock
- Building a Web Application using Thymeleaf, Alpine.js, Bootstrap
- Monitoring & Observability using Grafana, Prometheus, Loki, Tempo

## Local Development Setup

1. Install Java 21 (recommended to use SDKMAN for managing Java versions)
2. Install [Docker Desktop](https://www.docker.com/products/docker-desktop/)
3. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/) or your preferred IDE
4. Install [Postman](https://www.postman.com/) or any REST Client