# Smart Matching Service

The Smart Matching Service is a Spring Boot application designed to facilitate matchmaking between buyers and suppliers based on industry and product requirements. It provides RESTful API endpoints for finding matching suppliers for buyers and vice versa.

## Key Features:
- Matching buyers with suitable suppliers
- Matching suppliers with potential buyers
- Filtering suppliers and buyers by industry
- Filtering suppliers and buyers by product
- RESTful API with Swagger documentation

## Tech Stack:
- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database (for development)
- Maven
- Springdoc OpenAPI (Swagger) for API documentation

## API Endpoints:
- GET /api/matching/buyer/{buyerId}/suppliers
- GET /api/matching/supplier/{supplierId}/buyers
- GET /api/matching/suppliers?industry={industry}
- GET /api/matching/buyers?industry={industry}
- GET /api/matching/buyers/product?product={product}
- GET /api/matching/suppliers/product?product={product}

For detailed API documentation, run the application and visit: http://localhost:8080/swagger-ui.html
