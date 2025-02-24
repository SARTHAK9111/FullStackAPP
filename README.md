# Spring Boot Microservices Project

## Overview
This project is a **comprehensive microservices-based system** built using **Spring Boot**, implementing key features such as **service discovery, inter-service communication, distributed tracing, fault tolerance, message queues, API gateways, and containerization** using **Docker and Kubernetes**.

## Features Implemented

### 1. **Service Registry and Inter-Service Communication**
- **Service Registry (Eureka Server):** Setup for service discovery.
- **Microservices Registration:** Registered **Job, Company, and Ratings Microservices** with Eureka Server.
- **Inter-Service Communication:** Implemented using `@LoadBalanced` RestTemplate.
- **DTO Pattern:** Used Data Transfer Objects to restructure responses.
- **Heartbeat Mechanism:** Understanding Eureka's registration process.

### 2. **Working with OpenFeign**
- **Introduction to OpenFeign:** Implemented OpenFeign clients to enable declarative REST calls.
- **Feign Clients Activation:** Enabled Feign Clients for seamless communication.

### 3. **Distributed Tracing with Zipkin**
- **Zipkin Setup:** Installed and configured Zipkin for tracing.
- **Micrometer Integration:** Enabled distributed tracing in Spring Boot microservices.
- **Troubleshooting:** Common problems and their resolutions.

### 4. **Configuration Management with Spring Cloud Config Server**
- **Spring Cloud Config Server Setup:** Centralized configuration management.
- **Git-Backed Configuration:** Mapped configuration properties to a remote Git repository.
- **Spring Cloud Config Client:** Integrated services with Config Server.

### 5. **API Gateway with Spring Cloud Gateway**
- **Gateway Introduction & Setup:** Implemented API Gateway using Spring Cloud Gateway.
- **Service Discovery via API Gateway:** Integrated Eureka Server with API Gateway.
- **Routing & Load Balancing:** Configured HTTP vs. Load Balancer (`lb://` mechanism).

### 6. **Fault Tolerance and Circuit Breaking**
- **Resilience4J Integration:** Implemented circuit breakers, retry mechanisms, and fallback strategies.
- **Rate Limiting:** Implemented request throttling using Resilience4J.

### 7. **Message Queues with RabbitMQ**
- **Queue-Based Communication:** Integrated RabbitMQ for asynchronous message passing.
- **Publishing & Consuming Messages:** Implemented message-driven microservices.
- **Updating Ratings from Queues:** Processed and updated company ratings after message consumption.

### 8. **Packaging Microservices into JARs**
- **Microservices Packaging:** Built executable JARs for deployment.
- **Testing Packaged Applications:** Validated the functionality post-packaging.

### 9. **Containerization with Docker**
- **Spring Boot Profiles:** Configured profiles for different environments.
- **Dockerized Microservices:** Created Docker images for each microservice.
- **Multi-Container Setup:** Used Docker Compose to manage multi-container applications.

### 10. **Orchestration with Kubernetes**
- **Kubernetes Introduction:** Setup and managed containerized applications.
- **Minikube Dashboard:** Used Minikube for local Kubernetes cluster management.
- **Pods, Services, ReplicaSets, and Deployments:** Defined Kubernetes configurations.
- **Application Exposure:** Ensured proper service accessibility and scaling.

## Technologies Used
- **Java** (Spring Boot, Spring Cloud, Spring Data, Spring Security, Spring Config)
- **Service Discovery & API Gateway:** Eureka, Spring Cloud Gateway
- **Inter-Service Communication:** RestTemplate, OpenFeign
- **Distributed Tracing:** Zipkin, Micrometer
- **Circuit Breaking & Fault Tolerance:** Resilience4J
- **Message Queues:** RabbitMQ
- **Configuration Management:** Spring Cloud Config Server
- **Containerization & Orchestration:** Docker, Docker Compose, Kubernetes (Minikube)
- **Build & Packaging:** Maven

## How to Run

### **Prerequisites**
- Install **Java 17+**, **Maven**, **Docker**, **Kubernetes (Minikube)**, and **RabbitMQ**.

### **Steps to Run the Microservices**
#### **1. Start Eureka Server**
```sh
cd service-registry
mvn spring-boot:run
```
#### **2. Start Config Server**
```sh
cd config-server
mvn spring-boot:run
```
#### **3. Start Microservices**
```sh
cd job-service
mvn spring-boot:run

cd company-service
mvn spring-boot:run

cd ratings-service
mvn spring-boot:run
```
#### **4. Start API Gateway**
```sh
cd api-gateway
mvn spring-boot:run
```
#### **5. Run RabbitMQ for Message Queue**
```sh
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```
#### **6. Run Zipkin for Distributed Tracing**
```sh
docker run -d -p 9411:9411 openzipkin/zipkin
```
#### **7. Run Microservices in Docker**
```sh
docker-compose up --build
```
#### **8. Deploy Microservices in Kubernetes**
```sh
kubectl apply -f kubernetes/
kubectl get pods
```

## Future Enhancements
- **OAuth2 Authentication & Authorization**
- **Logging & Monitoring (ELK Stack, Prometheus, Grafana)**
- **GraphQL API Support**
- **Integration with CI/CD Pipeline (GitHub Actions, Jenkins)**

---
### **Author**
**Sarthak Raghuvanshi**

For any queries, feel free to reach out!


