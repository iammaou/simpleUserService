# User Service Application

## Goal

To provide a stateless Spring Boot REST microservice for managing US platform users, validating regional information via an external postal code API, and providing US regional statistics (app usage by state, city, etc.) for analytics and dashboard visualization. 

---

## Architecture & Tech Stack

The application runs as a stateless microservice within a containerized environment: 
- **Backend Framework:** Java with Spring Boot (Gradle build system). 
- **Data Persistence:** PostgreSQL database for user profiles and regional analytics persistence. 
- **External API Integration:** Zipcodebase API (`app.zipcodebase.com`) for automated US postal code lookup and region extraction. 
- **Validation:** Spring Boot Validation for input bounds (preventing future birth dates, invalid emails, etc.). 
- **Containerization:** Docker & Docker Compose setup linking the Spring Boot app and PostgreSQL instance. 
- **API Testing:** Postman collection provided (`SimpleUserService.postman_collection.json`). 

### Project Stack Breakdown

- **Framework:** Spring Boot (Gradle) 
- **Database:** PostgreSQL 
- **External Service:** Zipcodebase API 
- **DevOps:** Docker, Docker Compose (`docker-compose.yaml`, `docker-compose-dev.yaml`) 

---

## Key Features & Functionality

- **US User Tracking:** Stores first name, last name, email, date of birth, and validated region details (postal code, state, city). 
- **Automated Region Extraction:** Integrates with Zipcodebase API to pull location metrics using solely the postal code. 
- **Regional Analytics & Statistics:** Aggregates and retrieves user metrics grouped by city and state for external graphs and reporting. 
- **Input Validation:** Enforces strict Spring Boot validation rules on incoming request payloads. 
- **Stateless Microservice:** Scalable architecture configured for containerized deployments. 

---

## Requirements

- Docker and Docker Compose (or Docker Desktop) 
- Postman (for endpoint testing) 
- Zipcodebase API Key (`https://app.zipcodebase.com`) 

---

## Environment Variables

| Environment Variable | Description / Source |
|---|---|
| `API_KEY` | Zipcodebase API key retrieved from `https://app.zipcodebase.com` | 

---

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/iammaou/user-management-service.git
   cd simple-user-service
   ``` 

2. **Configure Environment Variables:**
   Add your `API_KEY` into the backend environment section of `docker-compose.yaml`. 

3. **Start the Application:**
   ```bash
   docker compose up -d
   ``` 

---

## Usage & Testing

1. Import `SimpleUserService.postman_collection.json` into Postman. 
2. Configure the Postman environment variables for your local base URL. 
3. Execute user creation, validation, and regional statistics endpoints. 
