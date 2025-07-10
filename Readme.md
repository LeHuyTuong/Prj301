
# Java Web CRUD Application - MVC2 Pattern

## 🧩 Mô tả Dự Án

Đây là một ứng dụng web đơn giản được xây dựng bằng **Java Servlet** theo mô hình **MVC2**, nhằm mục tiêu minh họa cách hoạt động của các thành phần như:
- **Servlets** (Controller)
- **Java Beans / DTO / DAO** (Model)
- **JSP** (View)
- **Filter** (Front Controller Pattern)

Chức năng chính:
- Đăng ký, đăng nhập và đăng xuất tài khoản
- Tìm kiếm người dùng theo họ
- Tìm kiếm mặt hàng
- Thêm, xóa sản phẩm khỏi giỏ hàng
- Tính tổng tiền trong giỏ hàng

## 📁 Cấu Trúc Thư Mục

```
├── src/
│   ├── controller/
│   │   ├── FilterDispatcher.java
│   │   ├── DispatchServlet.java
│   │   ├── CreateAccountServlet.java
│   │   ├── CheckAccountServlet.java
│   │   ├── LogoutAccountServlet.java
│   │   ├── AddToCartServlet.java
│   │   ├── RemoveItemCartServlet.java
│   │   ├── CartServlet.java
│   │   ├── CaculatorServlet.java
│   │   ├── DeleteServlet.java
│   │   ├── SearchLastnameServlet.java
│   │   ├── SearchItemServlet.java
│   │   ├── UpdateAccountServlet.java
│   ├── model/
│   │   ├── SigninDAO.java
│   │   ├── SigninDTO.java
│   │   ├── SigninCreateError.java
│   │   ├── ItemDAO.java
│   │   ├── ItemDTO.java
│   │   ├── CartObject.java
│   ├── utils/
│   │   ├── DBHelper.java
├── web/
│   ├── login.jsp
│   ├── search.jsp
│   ├── cart.jsp
│   ├── createAccount.jsp
│   ├── ...
│
├── WEB-INF/
│   ├── web.xml
```

## 🚀 Cách Chạy Dự Án

1. Mở project trong IDE hỗ trợ Java Servlet như **NetBeans** hoặc **Eclipse**.
2. Cấu hình server (Tomcat hoặc GlassFish).
3. Import database (file script SQL nếu có).
4. Build và deploy ứng dụng.
5. Truy cập đường dẫn: `http://localhost:8080/[project-name]/`

## 🛠 Công Nghệ Sử Dụng

- Java Servlet
- JSP
- JDBC
- MVC2 Pattern
- Filter (Front Controller)
- Apache Tomcat / GlassFish
- MySQL (hoặc SQL Server)

## 🔐 Các Chức Năng Chính

| Chức năng                | Mô tả                                                                 |
|--------------------------|------------------------------------------------------------------------|
| Đăng nhập                | Xác thực tài khoản từ cơ sở dữ liệu                                    |
| Tạo tài khoản            | Thêm tài khoản mới với kiểm tra lỗi đầu vào                            |
| Tìm kiếm theo họ         | Truy vấn danh sách người dùng từ họ tên                                |
| Thêm vào giỏ hàng        | Lưu sản phẩm vào session giỏ hàng                                      |
| Xem / Xóa giỏ hàng       | Hiển thị danh sách và xóa từng sản phẩm khỏi giỏ                       |
| Tính tổng tiền           | Tính tổng đơn hàng trong giỏ                                           |
| Tìm kiếm sản phẩm        | Lọc sản phẩm theo tên                                                  |
| Cập nhật tài khoản       | Cập nhật thông tin người dùng                                          |
| Xóa tài khoản            | Xóa người dùng khỏi hệ thống                                           |
| Đăng xuất                | Xóa session và chuyển về trang đăng nhập                               |

## 🧪 Kiểm Thử

- Đăng nhập: sử dụng các tài khoản đã có trong database
- Thêm sản phẩm: chọn sản phẩm và bấm "Add"
- Kiểm tra giỏ hàng: vào trang `cart.jsp`
- Thử xóa sản phẩm, đăng xuất, tạo account mới để xác minh hoạt động

## 📌 Ghi Chú

- **FilterDispatcher.java** đóng vai trò điều hướng trung tâm (Front Controller).
- **DispatchServlet.java** định tuyến đến các Servlet Controller cụ thể dựa trên tham số `btAction`.
- **Session** được dùng để lưu trạng thái người dùng và giỏ hàng.

## 📄 License

Dự án này phục vụ cho mục đích học tập. Bạn được phép sao chép, chỉnh sửa và sử dụng lại trong các project cá nhân.

