package vn.techmaster.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.techmaster.springjpa.entity.Employee;

// Câu 14

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Tìm tất cả các Employee theo emailAddress và lastName
    @Query(value = "select * from employee where email_address = ?1 and last_name= ?2", nativeQuery = true)
    List<Employee> findByEmailAndName(String emailAdress, String lastName);

    // Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    @Query(value = "select distinct * from employee where first_name = ?1 or last_name= ?2", nativeQuery = true)
    List<Employee> findDestinctByEmail(String firstName, String lastName);

    // Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng
    // dần
    @Query(value = "select * from employee where last_name = ?1 order by first_name asc", nativeQuery = true)
    List<Employee> findAndOrderByName(String lastName);

    // Tìm tất cả các Employee theo fistName không phân biệt hoa thường
    @Query(value = "select * from employee where first_name = ?1 ", nativeQuery = true)
    List<Employee> findByFirstName(String firstName);
}
