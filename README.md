# 📝 Task Manager API (Spring Boot & JWT)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## 🌟 Introduction & Project Scope
This project is an advanced **Backend API** for task management, built with **Spring Boot 3** and **Spring Security 6**. It is designed to provide a secure, organized environment for users to manage their productivity through a hierarchical data structure.

### 💡 Core Logic (How it works)
The system relies on three fundamental layers of data management:

* **Identity & Access Management:** The system handles user registration with `BCrypt` password encryption and issues secure **JSON Web Tokens (JWT)**. This ensures that users can only access their personal data while keeping the server **Stateless** (no session overhead).
* **Multi-level Organization:** Beyond simple tasks, the project introduces **"Task Lists"** that act as independent containers. This allows users to categorize tasks by context (e.g., Work, Study, Personal), providing a superior organizational experience.
* **Relational Integrity:** The database is architected to maintain strict relationships. Each **Task** belongs to a **List**, and each List belongs to a **User**. This hierarchy ensures data isolation and prevents unauthorized data access across accounts.



---

## 🚀 Key Features
* **Secure Authentication:** Fully implemented Login/Register flow using JWT.
* **Comprehensive Task Management:** Full CRUD operations for both Task Lists and individual Tasks.
* **Stateless Security:** Protected endpoints using a custom `JwtAuthFilter` in Spring Security.
* **Performance Optimization:** Utilizes `JOIN FETCH` in JPA to solve the N+1 problem and reduce database overhead.
* **Clean Architecture:** Separation of concerns using **DTOs** (Data Transfer Objects) and clear Service/Repository layers.
* **Interactive Documentation:** Integrated **Swagger/OpenAPI** for real-time API testing.

---

## 🛠️ Tech Stack
* **Backend:** Spring Boot 3, Spring Security 6, Spring Data JPA.
* **Security:** JJWT library for Token generation and parsing.
* **Database:** PostgreSQL / MySQL (Supports H2 for development).
* **Documentation:** SpringDoc OpenAPI (Swagger UI).

---

## 📖 API Documentation
Once the application is running, you can access the interactive Swagger UI at:
> `http://localhost:9090/swagger-ui/index.html`

### Primary Endpoints:

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/auth/register` | Create a new user account | No |
| `POST` | `/api/v1/auth/login` | Authenticate and get JWT Token | No |
| `GET` | `/api/v1/task-lists` | Retrieve all user's task lists | **Yes** |
| `POST` | `/api/v1/task-lists` | Create a new task list | **Yes** |

---

## ⚙️ Setup & Installation

1. **Clone the repository:**
```bash
git clone [https://github.com/your-username/task-manager-api.git](https://github.com/your-username/task-manager-api.git)
```
2. Run the application:
```bash
./mvnw spring-boot:run 
```

---

## 🔐 Security Flow (How to use)

Step 1 - Login: Send a POST request to /api/v1/auth/login with your credentials.
Step 2 - Get Token: Copy the generated JWT Token from the JSON response.
Step 3 - Authorize: Include the token in the Header of all subsequent requests:

`Authorization: Bearer <your_jwt_token>`

