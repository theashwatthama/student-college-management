# 🎓 College Management System

A backend-focused **College Management System** built with **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project demonstrates how real-world college entities can be modeled using **JPA entity relationships**, persisted using Hibernate, and exposed through **RESTful APIs**.

---

## 📌 Overview

The College Management System manages the core relationships between:

- 👨‍🏫 Professors
- 👨‍🎓 Students
- 📚 Subjects
- 📝 Admission Records

The primary goal of this project is to understand and implement **Spring Data JPA relationships**, database mapping, repository operations, and REST API development.

---

## ✨ Key Features

- 👨‍🏫 Professor management
- 👨‍🎓 Student management
- 📚 Subject management
- 📝 Admission record management
- 🔗 One-to-One relationship mapping
- 🔗 One-to-Many relationship mapping
- 🔗 Many-to-One relationship mapping
- 🔗 Many-to-Many relationship mapping
- 🗄️ MySQL database integration
- ⚡ Hibernate ORM
- 🌐 RESTful APIs
- 🧪 API testing with Postman
- 📊 Database inspection using DBeaver

---

## 🏗️ System Architecture

```text
                 ┌──────────────────┐
                 │    Professor     │
                 │                  │
                 │ id               │
                 │ name             │
                 └────────┬─────────┘
                          │
                       1  │
                          │  N
                 ┌────────▼─────────┐
                 │     Subject      │
                 │                  │
                 │ id               │
                 │ subjectName      │
                 │ professor_id     │
                 └──────────────────┘


        N ┌──────────────────┐ N
          │     Student      │
          │                  │
          │ id               │
          │ name             │
          └────────┬─────────┘
                   │
                1  │
                   │  1
          ┌────────▼─────────┐
          │ AdmissionRecord  │
          │                  │
          │ id               │
          │ fees             │
          │ student_id       │
          └──────────────────┘
