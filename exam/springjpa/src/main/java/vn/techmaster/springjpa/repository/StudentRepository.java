package vn.techmaster.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.techmaster.springjpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Trả về danh sách sinh viên tham gia từng môn học
    @Query(value = "select * from student s inner join student_course sc on s.id = sc.student_id inner join course c on c.id = sc.course_id where c.name = ?1", nativeQuery = true)
    List<Student> getStudentsByCourse(String courseName);

    // Liệt kê danh sách sinh viên học math nhưng không học music
    @Query(value = "select * from student s inner join student_course sc on s.id = sc.student_id inner join course c on c.id = sc.course_id where c.name = 'math' and c.name <> 'music'", nativeQuery = true)
    List<Student> searchByCourse();
}
