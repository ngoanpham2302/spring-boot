package vn.techmaster.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository {

    // Viết Native Query để tính điểm trung bình một môn bất kỳ

    @Query(value = "select avg(score) from course c inner join student_course sc on c.id = sc.course_id where c.name = ?1 group by c.id", nativeQuery = true)
    float calAverageScoreByCourse(String courseName);
}
