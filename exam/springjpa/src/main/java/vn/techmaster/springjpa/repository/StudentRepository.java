package vn.techmaster.springjpa.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.techmaster.springjpa.entity.Student;

public interface StudentRepository extends JpaRepository {
    // Trả về liệt kê sinh viên tham gia từng môn học Map<String, List<Student>>:
    // key là tên môn học, value là danh sách sinh viên đăng ký
    @Query(value = "select * from student  where first_name = ?1 ", nativeQuery = true)
    Map<String, List<Student>> getStudentByCourse();

    // Liệt kê danh sách sinh viên học math nhưng không học music
    @Query(value = "select * from student  where first_name = ?1 ", nativeQuery = true)
    List<Student> searchByCourse();

}
