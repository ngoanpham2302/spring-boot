1. Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây: `groupID`, `artifactID`. Ý nghĩa các tham số này là gì?

- `groupID`: id của tổ chức, nhóm tạo ra dự án
- `artifactID`: id của dự án, cũng là tên package chính của dự án

---

2. Tại sao phải đảo ngược tên miền trong `<groupId>vn.techmaster</groupId>`?

- Đảo ngược tên miền để phân biệt công ty, tổ chức sở hữu dự án, xác định dự án là duy nhất, tránh nhầm lẫn với các dự án khác.

---

3. SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?

- 2 cơ chế quản lý thư viện: Maven và Gradle

---

4. File `pom.xml` có tác dụng gì?

- pom (Project Object Model): là một tệp XML khai báo thông tin về dự án được cấu hình qua Maven, bao gồm tên tổ chức, tên dự án, version, các dependency,...

---

5. Trong file `pom.xml` có các thẻ dependency. Ý nghĩa của chúng là gì?

- Thẻ `<dependency>`: xác định 1 thư viện sử dụng trong dự án, nằm trong thẻ `<dependencies>` (các thư viện sử dụng trong dự án)

---

6. Ý nghĩa của `@Controller` là gì?

- Đánh dấu đây là 1 Controller, là nơi tiếp nhận các request từ phía client
- Cụ thể, definition của `@Controller` như sau:

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Controller {
   @AliasFor(annotation = Component.class)
   String value() default "";
}
```

- Trong đó:
  - `@Target(ElementType.TYPE)`: annotation này chỉ áp dụng cho khai báo kiểu ví dụ class, interface, record, không áp dụng cho phương thức.
  - `@Retention(RetentionPolicy.RUNTIME)`: annotation này chỉ có hiệu lực khi ứng dụng chạy, không có hiệu lực khi code, test, hay build !
  - `@Documented`: đảm bảo chắc chắn rằng annotation này sẽ được liệt kê khi tạo văn bản chú thích mã nguồn.
  - `@Component`: đánh dấu class, interface sẽ trở thành bean component, sẽ được Spring Boot quét (scan) và ghi vào danh sách Application Context. Thông thường các bean component chỉ được khởi tạo 1 lần duy nhất, singleton.
- Như vậy các class được annotated bởi `@Controller` bản chất là một singleton bean component.

---

7. Ý nghĩa của `@RequestMapping` là gì? Nó có những tham số gì ngoài `value`?

- `@RequestMapping`: là annotation dùng để ánh xạ các request từ web tới các phương thức xử lý của Spring Controller
- Các tham số khác ngoài `value`: `produces`, `consumes`, `headers`, `method`, `params`, `name`, `path`

---

8. Ý nghĩa của `@RequestBody` khi đặt trong hàm hứng request để làm gì?

- `@RequestBody`: được dùng để ánh xạ HttpRequest body sang một domain object, cho phép tự động hóa HttpRequest body gửi tới một Java object. Ví dụ, Spring sẽ tự động ánh xạ dữ liệu JSON trong HttpRequest body sang một Java Type object tương ứng.

---

9. Hãy trả lời khi nào thì dùng `@PathVariable` và khi nào nên dùng `@RequestParam`

- @RequestParam và @PathVariable là hai annotation được sử dụng để truy cập dữ liệu từ các request. Trong đó:
  - @RequestParam được sử dụng để truy cập giá trị của tham số trên URL (tham số trong query string)
  - @PathVariable được sử dụng để lấy giá trị trên URI theo template (thành phần đường dẫn).

---

10. Thứ tự các thành phần đường dẫn `@PathVariable` có thể hoán đổi được không?

- Không thể

---

11. `@GetMapping` khác gì so với `@PostMapping`?

- `@GetMapping` được sử dụng để xử lý Http GET request, khi chỉ cần lấy ra data
- `@PostMapping` được sử dụng để xử lý Http POST request, khi cần thực hiện thêm, cập nhật data

---

12. Trong các annotation `@RequestMapping`, `@GetMapping`, `@PostMapping`… có tham số `produces = MediaType.XXXX` ý nghĩa tham số này là gì?

- `produces`: khai báo kiểu dữ liệu của response

---

13. Giải thích ý nghĩa của `@RequestBody` trong đoạn code dưới đây:

```java
@PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Message echoMessage(@RequestBody Message message){
    return message;
}
```

- `@RequestBody` tự động ánh xạ dữ liệu JSON trong HttpRequest body sang Java Object Type là Message

---

14. Cổng mặc định ứng dụng SpringBoot là 8080. Hãy google cách để thay đổi cổng lắng nghe mặc định

- VD: Thay đổi thành cổng 8090. Có 2 cách:
  - Cách 1: Cấu hình trong file `application.properties` nằm trong folder resources: `server.port = 8090`
  - Cách 2: Sửa đổi VM options: vào Run -> Configuration -> VM Options. Chỉnh sửa VM Options thành `-Dserver.port=8090`
