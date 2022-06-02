1. Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế
   nào? Hãy giải thích rõ cần thì minh hoạ

- `@Entity`: name trong @Entity để chỉ tên của entity được Hibernate quản lý
- `@Table`: name trong @Table là tên của bảng trong database

---

2. Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?

- Thêm `spring.jpa.show-sql` để log ra SQL statement được thực thi trong quá trình chạy project để tiện debug

---

3. Khi sử dụng H2, làm thế nào để xem được cơ sở dữ liệu và viết câu truy vấn?

- Để xem được cơ sở dữ liệu, đầu tiên chúng ta có thể truy cập vào địa chỉ http://localhost:8080/h2-console trên giao diện trình duyệt đang sử dụng.
- Sau đó login để sử dụng, bằng cách điền đầy đủ thông tin đã cấu hình trong file application.properties như Driver class, JDBC URL, Username, Password.

---

4. Khi viết mô tả một model, những thuộc tính chúng ta không muốn lưu xuống CSDL thì cần đánh dấu bằng annotation nào?

- Thêm annotation `@Transient` cho thuộc tính đó

---

5. Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính. Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính, tham số nào chỉ định
   yêu cầu duy nhất, không được trùng lặp dữ liệu, tham số nào buộc trường không được null?

- Để đặt lại tên cột khác với tên thuộc tính, sử dụng thuộc tính `name` như sau: `@Column(name = “ten_cot”)`.
- Tham số chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu là `unique`: `@Column(unique = true)`
- Tham số nào buộc trường không được null là `nullable`: `@Column(nullable = false)`

---

6. Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung:

- Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT): `@PrePersist`
- Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE): `@PreUpdate`

---

7. Tổ hợp các trường thông tin địa chỉ: country, city, county, addressline thường luôn đi cùng
   nhau và sử dụng lại trong các Entity khác nhau. Nhóm 2 annotation nào dùng để tái sử dụng,
   nhúng một Entity vào một Entity khác?

- `@Embeddable` và` @Embedded`

---

8. JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận
   tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?

- `JpaRepository` extends `PagingAndSortingRepository`, `PagingAndSortingRepository` extends `CrudRepository`

---

9. Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là long, tuân thủ interface JpaRepository

- Tạo interface `PostRepository` như sau:

  ```java
  @Repository
  public interface PostRepository extends JpaRepository<Post, Long> {
  }
  ```

---

10. Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không?

- Không cần, vì @Id đánh dấu primary key, đã yêu cầu giá trị phải unique rồi.

---

11. Khác biệt giữa @Id với @NaturalId là gì?

- `@Id`: đánh dấu primary key. Entity phải có một annotation `@Id` nếu không sẽ báo lỗi.
- `@NaturalId`: chỉ ra cột được dùng như là id, hibernate sẽ cung cấp các api để loading entity theo cột này và mang lại các lợi ích giống như loading bằng cột id.

---

12. Có những cột không phải primary key (@Id) hay @NaturalId, dữ liệu có thể trùng lặp (unique không đảm bảo true), nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy phải dùng annotation gì? Hãy viết 1 ví dụ sử dụng annotation đó với index cho 1 column và 1 ví dụ với index cho tổ hợp nhiều column. Tham khảo tại (https://www.baeldung.com/jpaindexes)

- Annotation dùng khi cần đánh chỉ mục (index) để tìm kiếm nhanh hơn: `@Index`
- Ví dụ với index cho 1 column:

  ```java
  @Entity
  @Table(indexes = @Index(name = "nameIndex", columnList = "firstName"))
  public class Student implements Serializable {
      @Id
      @GeneratedValue
      private Long id;
      private String firstName;
      private String lastName;
      // getters, setters
  }
  ```

- Ví dụ với index cho tổ hợp nhiều column:

  ```java
  @Entity
  @Table(indexes = @Index(name = "multiIndex", columnList = "firstName, lastName"))
  public class Student implements Serializable {
      @Id
      @GeneratedValue
      private Long id;
      private String firstName;
      private String lastName;
      // getters, setters
  }
  ```

---

13. . Annotation @GeneratedValue dùng để chọn cách tự sinh unique id cho primary key phải là trường kiểu int hoặc long. Nếu trường primary key có kiểu là String, chúng ta không thể dùng @GeneratedValue vậy hãy thử liệt kê các cách đảm bảo sinh ra chuỗi có tính duy nhất?

- Sử dụng `@GeneratedValue` và ` @GenericGenerator`, tự định nghĩa generator, ví dụ:

  ```java
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
  name = "UUID",
  strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(updatable = false, nullable = false)
  private String id;
  ```

- Nếu tự định nghĩa class generator, thì class đó phải implements `IdentifierGenerator `

---

14. Giả sử có 1 class `Employee` với các fields sau {id, emailAddress, firstName, lastName}. Hãy viết các method trong interface `EmployeeRespository` để :

- Tìm tất cả các Employee theo emailAddress và lastName
  @Repository
  public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  public List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);
  }
- Tìm tất cả các Employee khác nhau theo firstName hoặc lastName

- Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
  @Repository
  public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  public List<Employee> findByLastNameOrderByFirstNameAsc(String lastName, String firstName);
  }

- Tìm tất cả các Employee theo firstName không phân biệt hoa thường

---

15. Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ

- @Query: sử dụng để khai báo truy vấn JPQL (Hibernate) hoặc raw SQL. VD:

  ```java
  @Query(value = "select \* from user u where u.email = ?1", nativeQuery = true)
  ```

- @NamedQuery: truy vấn có tên, sử dụng để khai báo truy vấn HQL, thuộc tính name của annotation định nghĩa tên của câu truy vấn. VD:

  ```java
  @NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.id=:userId")
  ```

---

16. Làm thế nào để có thể viết custom method implemetations cho Jpa Repository. Nêu ví dụ.

- Sử dụng annotation `@Query`, tự viết câu query thay vì đặt tên method, sẽ có thể tự định nghĩa các method:

  ```java
  @Repository
  public interface UserRepository extends JpaRepository<User, Integer> {
      @Query(value = "SELECT * FROM user u WHERE u.name = :name", nativeQuery = true)
      User findUserByName(@Param("name") String name);
  }
  ```

---

17. Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên

- VD: Mỗi page có 5 employee, lấy ra các employer ở page thứ 2, sắp xếp theo firstName giảm dần:

  ```java
  Page<Employee> page = employeeRepository.findAll(PageRequest.of(1, 5, Sort.by("firstName").descending()));
  ```
