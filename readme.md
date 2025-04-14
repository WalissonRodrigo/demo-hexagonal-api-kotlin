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
```
2. Wait for all containers to be healthy (usually takes about 30 seconds)

### Running the Application
* Option 1: Using Gradle
```bash
./gradlew bootRun
```

* Option 2: Build and Run JAR
```bash
./gradlew build
java -jar build/libs/hexagonal-demo-0.1.0.jar
```

### Accessing the API
The application will be available at http://localhost:8080

CRUD implemented: http://localhost:8080/api/v1/customers

### Project Structure
```
src/
├── main/
│   ├── kotlin/
│   │   └── br/com/hexagonal/api
│   │       ├── adapters/             # Implementation of ports (infrastructure layer)
│   │       │   ├── in/               # Inbound adapters handling incoming requests
│   │       │   │   ├── consumer/     # Kafka message consumers
│   │       │   │   ├── controller/   # REST API controllers
│   │       │   ├── out/              # Outbound adapters handling external systems
│   │       │   │   ├── client/       # HTTP clients for external services
│   │       │   │   ├── repository/   # Data persistence implementations
│   │       │   ├── AllAdapter.kt     # Implementation adapter interfaces
│   │       ├── application/          # Application layer
│   │       │   ├── core/             # Core application components
│   │       │   │   ├── domain/       # Business entities and value objects
│   │       │   │   ├── exceptions/   # Custom exception classes
│   │       │   │   ├── useCase/      # Business logic implementations
│   │       │   ├── ports/            # Interface definitions (ports)
│   │       │   │   ├── in/           # Input ports for receiving commands/queries
│   │       │   │   ├── out/          # Output ports for external system operations
│   │       ├── config/               # Spring configuration and dependency injection
│   │       └── HexagonalApplication.kt # Main application entry point
│   └── resources/
│       └── application.yml           # Application configuration
```
### Key Architecture Concepts
* **Domain (core)**: Pure business logic and entities, with no external dependencies
* **Ports**: Interfaces defining the boundaries of the application
  * **Output Ports**: Interfaces for the application to interact with external systems
  * **Input Ports**: Interfaces for operations triggered from outside
* **Adapters**: Implementations connecting the application to the outside world
  * **Inbound Adapters**: Handle requests coming into the application (controllers, consumers)
  * **Outbound Adapters**: Handle interactions with external systems (repositories, clients)
* **Use Cases**: Application-specific business rules implementing input ports

### Hexagonal Architecture Flow
1. External requests enter through **inbound adapters** (controllers, consumers)
2. Adapters convert requests to application-specific format and invoke **use cases**
3. Use cases implement business logic using the **domain** model
4. When external resources are needed, use cases call **output ports**
5. **Outbound adapters** implement these ports to interact with external systems
6. Responses flow back through the same layers in reverse

### Learning Path
1. Study the domain models in the core package to understand business concepts
2. Examine the port interfaces that define application boundaries
3. See how use cases implement business logic using these ports
4. Look at how adapters connect the application to the outside world
5. Observe the clear separation between business logic and infrastructure concerns

### Contributing
Feel free to submit issues, fork the repository and send pull requests!

### License
This project is licensed under the MIT License - see the LICENSE file for details.
