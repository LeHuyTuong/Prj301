
# Java Web CRUD Application - MVC2 Pattern

## 📚 Giới thiệu

Đây là dự án Web Application được xây dựng dựa trên mô hình **MVC2**, sử dụng công nghệ **Java Servlet**, **JSP**, **JDBC**, hướng đến việc quản lý tài khoản người dùng với các chức năng:

✅ Đăng nhập 
✅ Đăng ký tài khoản  
✅ Tìm kiếm tài khoản theo Lastname  
✅ Cập nhật mật khẩu và phân quyền  
✅ Xóa tài khoản  
✅ Quản lý Session, Cookies  
✅ Xử lý lỗi hệ thống và người dùng  

Ứng dụng triển khai trên server **Apache Tomcat**, thao tác trực tiếp với cơ sở dữ liệu thông qua lớp **DAO** và mô hình truyền dữ liệu **DTO**.

---

## 🏗️ Cấu trúc dự án

```
WebApp/
├── Web Pages/
│   ├── createAccount.html
│   ├── createAccount.jsp
│   ├── login.html
│   ├── search.html
│   ├── search.jsp
│   ├── invalid.html
│   ├── error.html
│   └── WEB-INF/
│       └── web.xml
├── Source Packages/
│   ├── tuonglh.controller/
│   │   ├── DispatchServlet.java
│   │   ├── CreateAccountServlet.java
│   │   ├── UpdateAccountServlet.java
│   │   ├── DeleteAccountServlet.java
│   │   ├── LogoutAccountServlet.java
│   │   ├── CheckAccountServlet.java
│   │   └── SearchLastnameServlet.java
│   ├── tuonglh.registration/
│   │   ├── RegistrationDTO.java
│   │   ├── RegistrationDAO.java
│   │   └── RegistrationCreateError.java
│   └── tuonglh.utils/
│       └── DBHelper.java
```

---

## 🔧 Công nghệ sử dụng

- **Java Servlet 3.1**
- **JSP - JSTL**
- **JDBC - Kết nối CSDL**
- **HTML/CSS đơn giản**
- **Apache Tomcat Server**
- **MVC2 Pattern**
- **Session, Cookies, Hidden Fields**

---

## 💡 Mô hình hoạt động (MVC2)

- **Model**:  
  `RegistrationDAO`, `RegistrationDTO`, `DBHelper` xử lý logic và tương tác cơ sở dữ liệu.

- **View**:  
  Các file `.jsp`, `.html` hiển thị giao diện người dùng.

- **Controller**:  
  Các Servlet đóng vai trò điều hướng, xử lý nghiệp vụ:
  - `DispatchServlet` là trung tâm điều phối yêu cầu
  - Các Servlet chuyên biệt: `LoginServlet`, `CreateAccountServlet`, `UpdateAccountServlet`, v.v...

---

## 🚀 Hướng dẫn triển khai

1. Cài đặt **JDK**, **Apache Tomcat**
2. Cấu hình Database (tùy theo yêu cầu, cấu trúc bảng do bạn định nghĩa)
3. Import project vào IDE (NetBeans, Eclipse,...)
4. Build và Deploy project
5. Truy cập:  
   `http://localhost:8080/YourAppContext/`

---

## ⚙️ Các tính năng chính

- **Đăng nhập (`login.html`)**  
  Người dùng nhập tài khoản, mật khẩu, được kiểm tra qua `CheckAccountServlet`.

- **Đăng ký tài khoản (`createAccount.html` / `createAccount.jsp`)**  
  Xử lý bởi `CreateAccountServlet`, kiểm tra ràng buộc dữ liệu.

- **Tìm kiếm tài khoản (`search.html` / `search.jsp`)**  
  Tra cứu theo Lastname, hiển thị bảng dữ liệu, có nút Delete, Update từng dòng.

- **Xóa tài khoản (`DeleteAccountServlet`)**

- **Cập nhật thông tin (`UpdateAccountServlet`)**

- **Quản lý Session, Cookies**  
  Lưu thông tin đăng nhập để tránh login lại nhiều lần.

- **Xử lý lỗi**  
  - Sai tài khoản: `invalid.html`  
  - Lỗi hệ thống: `error.html`  

---

## 📁 Cấu hình `web.xml` mẫu

```xml
<servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>tuonglh.controller.LoginServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
</servlet-mapping>

<welcome-file-list>
    <welcome-file>DispatchServlet</welcome-file>
</welcome-file-list>

<session-config>
    <session-timeout>30</session-timeout>
</session-config>
```

---

## 🎯 Mục tiêu học tập

✅ Hiểu rõ mô hình **MVC2**, phân tách rõ ràng View - Controller - Model  
✅ Thành thạo thao tác Servlet, JSP, JDBC  
✅ Triển khai các kỹ thuật quản lý Session, Cookies, Error Handling  
✅ Hiểu luồng hoạt động từ client gửi request đến server xử lý trả về giao diện  
✅ Chuẩn bị nền tảng cho các dự án nâng cao về Web Application  
