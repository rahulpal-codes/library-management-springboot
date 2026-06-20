# Library Management System — Spring Boot + JWT

A secured backend REST API for managing library books, members, and loans
with JWT-based authentication.

## Tech Stack
Java 17 · Spring Boot 3.x · Spring Security · JWT · Spring Data JPA ·
Hibernate · MySQL · Maven · Lombok

## Features
- JWT authentication (register/login) with BCrypt password hashing
- Role-based secured endpoints (USER/ADMIN)
- Book, Member, and Loan management (CRUD)
- Book issue/return with availability tracking and 14-day due dates
- One-to-Many relationships (Member–Loan, Book–Loan)
- Transactional business logic, validation, global exception handling

## Key Endpoints
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | /api/auth/register | No | Register + get token |
| POST | /api/auth/login | No | Login + get token |
| POST | /api/books | Yes | Add a book |
| GET | /api/books | Yes | List all books |
| POST | /api/loans/issue | Yes | Issue book to member |
| POST | /api/loans/return/{id} | Yes | Return a book |

## Setup
1. Clone repo
2. Update MySQL password in `application.properties`
3. Run `./mvnw spring-boot:run`
4. Register at `/api/auth/register` to get a JWT token
5. Use token (Bearer) to access secured endpoints
