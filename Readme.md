# Online Book Store Web Application

## Overview
This is a web-based project simulating an online bookstore using **Java Servlet**, **JSP**, **JavaBeans**, **JSTL**, and **MVC2** architecture. It demonstrates how to build a CRUD application with shopping cart functionality while applying key concepts such as **session tracking**, **filter chains**, **JavaBeans**, **custom tag libraries**, and **MVC separation**.

---

## Features

### ✅ User Account Management
- **Login / Logout** (with cookies or session)
- **Register** new account (`CreateAccountServlet`)
- **Update** and **delete** account info (`UpdateAccountServlet`, `DeleteServlet`)

### 🔍 Search
- Search users by last name (`SearchLastnameServlet`)
- Search books/items (`SearchItemServlet`)

### 🛒 Shopping Cart
- Add items to cart (`AddToCartServlet`)
- View cart and update quantity (`CartServlet`, `CaculatorServlet`)
- Remove items from cart (`RemoveItemCartServlet`)

### ✨ Filter-based Controller (MVC2 Pattern)
- Uses `FilterDispatcher` to route all requests
- Acts as the **Controller** of the MVC2 architecture

---

## Technologies Used
- **Java Servlet & JSP**
- **JavaBeans** for DTO (e.g., `ItemDTO`, `SigninDTO`) and DAO (e.g., `ItemDAO`, `SigninDAO`)
- **Session Tracking** via `HttpSession` and cookies
- **JSTL** for view logic
- **Custom Tag Library** (via `.tld`) to abstract repetitive view logic
- **Filter API** for request interception and dispatching

---

## Architecture

### MVC2 with Filter as Controller
- **Model**: JavaBeans (DTO/DAO)
- **View**: JSP with JSTL/EL, taglibs
- **Controller**: `FilterDispatcher.java` intercepts all requests and dispatches to appropriate Servlets
---

## Key Java Files
- `FilterDispatcher.java`: routes requests based on URI suffix (e.g. `action=Search` dispatches to `SearchItemServlet`)
- `DispatchServlet.java`: legacy front controller
- `AddToCartServlet.java`, `CartServlet.java`: manage cart flow
- `SigninDAO.java`, `ItemDAO.java`: JDBC logic for users and items

---

## Learning Topics

### 1. Filters
- Centralized control logic
- Chain multiple filters if needed (`FilterChain`)
- Acts before Servlet logic (authentication, logging, etc.)

### 2. Sessions
- Cart is session-based (stored in `HttpSession`)
- Uses `CartObject.java` as a holder bean for cart items

### 3. JavaBeans
- Each data object (`SigninDTO`, `ItemDTO`) encapsulates properties with getters/setters
- DAO classes isolate JDBC logic

### 4. JSTL + EL
- View logic separated from business logic
- No Java code inside JSPs

---

## Deployment Instructions
1. Deploy on **Apache Tomcat 7+**
2. Place project inside `webapps` directory
3. Create MySQL database and configure `DBHelper.java`
4. Open browser at `http://localhost:8080/YourProjectName`

---

## Credits
- Code and materials based on lectures by **Kieu Trong Khanh**
- Sample project for academic purposes


---

## License
This project is licensed under the **MIT License**. See the [LICENSE](./LICENSE) file for more details.
