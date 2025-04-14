# Hexagonal Architecture in Action

A practical demonstration of hexagonal architecture using Kotlin, MongoDB and Kafka. This project shows how to structure microservices properly with domains, adapters and controllers in a real-world CRUD application.

Perfect for developers looking to level up, prepare for interviews, or learn better architecture practices.

## What You'll Find

This repository implements a complete microservice following hexagonal architecture (ports and adapters) principles, showcasing:

- Clean separation between business logic and external concerns
- Domain-driven design principles in practice
- Integration with external systems via adapters
- Asynchronous communication using Kafka
- Persistence with MongoDB
- RESTful API controllers

## Tech Stack

- **Language**: Kotlin
- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Database**: MongoDB
- **Messaging**: Apache Kafka
- **Containerization**: Docker

## Getting Started

### Prerequisites

- Docker and Docker Compose
- JDK 17 or higher
- Gradle 8.x or higher

### Running with Docker

1. Start the required infrastructure (MongoDB, Kafka):

```bash
docker-compose up -d