# ToDoApplication
A simple and efficient ToDo Application built using Spring Boot, designed to help users manage their daily tasks with ease. This project demonstrates CRUD operations, H2 Console integration for development, and MySQL for persistent storage.

# 📝 ToDo Application - Task Management System

A simple and efficient **ToDo Application** built using **Spring Boot**, designed to help users manage their **daily tasks** with ease. This project supports full CRUD operations, integrates H2 Console for development and MySQL for production-level persistence.

---

## 🚀 Features

- ✅ Add, update, delete, and view daily tasks
- 🕓 Track task completion status (Pending/Completed)
- 🧠 RESTful API endpoints
- 📋 In-memory **H2 Database** for testing and development
- 🗃️ Persistent storage using **MySQL**
- 📊 Ready for production environment switch
- 🔐 Easy configuration through `application.properties`

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **H2 Database (for development)**
- **Lombok**
- **Maven**

---

2️⃣ Configure Database
Update src/main/resources/application.properties:

For MySQL:
properties
Copy
Edit

spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

For H2 (Dev Mode):
properties
Copy
Edit

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
