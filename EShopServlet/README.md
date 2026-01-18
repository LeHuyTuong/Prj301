# 🛒 EShopServlet - E-Commerce Backend System

A Java web application demonstrating **JSP/Servlet architecture** with layered design patterns.

## 📋 Project Overview

| Aspect | Details |
|--------|---------|
| **Architecture** | 3-Layer (DAO → Service/BLO → Controller/Servlet) |
| **Frontend** | JSP + JSTL + HTML |
| **Backend** | Java Servlet (Jakarta EE) |
| **ORM** | JPA/Hibernate (EclipseLink) |
| **Database** | SQL Server |
| **IDE** | NetBeans |

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                      CLIENT (Browser)                        │
└─────────────────────────┬───────────────────────────────────┘
                          │ HTTP Request
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                    FilterDispatcher                          │
│              (Request Routing & Pre-processing)              │
└─────────────────────────┬───────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                  SERVLET LAYER (Controller)                  │
│  LoginServlet | AddItemServlet | SearchServlet | ...         │
└─────────────────────────┬───────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                  SERVICE LAYER (BLO)                         │
│           ItemBLO | SigninBLO (Business Logic)               │
└─────────────────────────┬───────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                    DAO LAYER                                 │
│         ItemDAO | SigninDAO (Data Access Objects)            │
│              JPA EntityManager + JDBC                        │
└─────────────────────────┬───────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                    DATABASE (SQL Server)                     │
└─────────────────────────────────────────────────────────────┘
```

## ✨ Features

### Authentication & Authorization
- User login/logout with session management
- Role-based access (Admin/User)
- Filter-based authentication check

### Product Management
- Search products by name
- Add new products (Admin)
- View product details

### Shopping Cart
- Add items to cart (stored in HttpSession)
- Remove items from cart
- View cart contents

### User Management
- User registration with validation
- CRUD operations for accounts (Admin)

## 📁 Project Structure

```
EShopServlet/
├── src/java/tuonglh/
│   ├── cart/              # Shopping cart logic
│   │   └── CartObject.java
│   ├── fillter/           # Servlet Filters
│   │   └── FilterDispatcher.java
│   ├── item/              # Product module
│   │   ├── Item.java          (Entity)
│   │   ├── ItemDTO.java       (Data Transfer Object)
│   │   ├── ItemDAO.java       (Data Access - JDBC)
│   │   ├── ItemBLO.java       (Business Logic - JPA)
│   │   └── ItemBLI.java       (Interface)
│   ├── itemSerlvet/       # Product Servlets
│   │   └── AddItemServlet.java
│   ├── registration/      # User module
│   │   ├── Signin.java        (Entity)
│   │   ├── SigninDTO.java     (Data Transfer Object)
│   │   ├── SigninDAO.java     (Data Access)
│   │   └── SigninBLO.java     (Business Logic)
│   ├── userservlet/       # User Servlets
│   └── utils/             # Utilities
│       └── DBHelper.java      (Connection Pool)
└── web/
    ├── *.jsp              # JSP Views
    ├── *.html             # Static pages
    └── WEB-INF/
        └── web.xml        # Deployment Descriptor
```

## 🛠️ Technologies & Concepts Demonstrated

| Category | Technology/Concept |
|----------|-------------------|
| **Servlet Lifecycle** | `init()` → `service()` → `doGet()/doPost()` → `destroy()` |
| **Design Patterns** | DAO Pattern, DTO Pattern, MVC |
| **ORM** | JPA with EntityManager, JPQL queries |
| **JDBC** | PreparedStatement (SQL Injection prevention) |
| **Session Management** | HttpSession for cart and authentication |
| **Filters** | Request/Response intercepting, URL routing |
| **Transaction** | `begin()` / `commit()` / `rollback()` |
| **Connection Pool** | DataSource via JNDI lookup |

## 🚀 Setup Instructions

### Prerequisites
- JDK 11+
- NetBeans IDE
- SQL Server
- Apache Tomcat 10+ (Jakarta EE)

### Database Setup
```sql
-- Create database
CREATE DATABASE EShopDB;

-- Users table
CREATE TABLE Signin (
    phoneNumber VARCHAR(15) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    name NVARCHAR(100),
    role BIT DEFAULT 0  -- 0=User, 1=Admin
);

-- Products table
CREATE TABLE Item (
    itemID VARCHAR(50) PRIMARY KEY,
    name NVARCHAR(200) NOT NULL,
    price DECIMAL(18,2),
    time DATETIME DEFAULT GETDATE()
);
```

### Run the Application
1. Open project in NetBeans
2. Configure database connection in `persistence.xml`
3. Right-click project → Run
4. Access: `http://localhost:8080/EShopServlet/`

## 📚 Learning Outcomes

This project demonstrates understanding of:

- ✅ Servlet lifecycle and HTTP request handling
- ✅ Layered architecture separation (Controller-Service-DAO)
- ✅ DTO pattern for data transfer between layers
- ✅ JPA/Hibernate for ORM with transaction management
- ✅ JDBC with PreparedStatement for secure queries
- ✅ Session management for stateful operations
- ✅ Filter chain for cross-cutting concerns

## 👤 Author

**Le Huy Tuong**  
Fresher Java Backend Developer

---

*This project was built as a learning exercise to understand Java web development fundamentals before transitioning to Spring Boot.*
