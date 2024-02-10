# User Service Application

# Goal


# Task : Create User Service

Your task it to create User Service that keeps track of users on our platform and provide US regional statistics.

## Service Requirements

### Information requirements
- User Service needs to keep track of these information: first name, last name, email, date of birth, region info (postal code, state, city *and/or other useful info by your choice*)
- This app supports only US users

### Technical requirements
- To insure correctness of region information validate all inputs (Spring Boot Validation) to prevent invalid emails, future dates of birth, and other edge cases
- It would be wise to extract all needed region information by using only postal code (use external API to extract the rest), this will prevent wrong region information
- We need to retrieve region statistics to be used in graphs and other services (app usage by state, city, ...)
- This service has to be stateless because it will live in a microservice architecture
- Use Docker to create a developer environment, and you will need to provide a Docker Compose to run this service with all dependencies (database, ...)
- Provide us with Postman Collection and Environment to test the app
- For every feature added write quality unit tests

### Development Guidelines
- Use GitHub Issues to create tasks and plan your project, this will help you brake it down into small chunks
- Use Git branching to work on individual issues (direct commits to main should be avoided)
- Avoid hardcoding data, especially passwords or other types of credentials -> Use ENVIRONMENT VARIABLES

### Base Tech Stack:
- Spring Boot
- Postgres Database
- Docker
- Postman


## Requirements

- Docker and Docker Compose or Docker Desktop
 https://app.zipcodebase.com
- Postman

| Environment variable | Where to find them                                              |
|----------------------|-----------------------------------------------------------------|
| API_KEY              | https://app.zipcodebase.com                                     |

## How to run

- Clone this repo
- Paste the API_KEY into the environment of the backend section
- Run:
```sh 
docker compose up -d
```

## Usage

- Import Postman collection and environment