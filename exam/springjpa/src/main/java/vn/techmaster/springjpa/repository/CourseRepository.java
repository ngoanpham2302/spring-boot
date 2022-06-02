package vn.techmaster.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.techmaster.springjpa.entity.Course;

public interface CourseRepository extends JpaRepository {

    // Viết Native Query để tính điểm trung bình một môn bất kỳ

    @Query(value = "select * from student  where first_name = ?1 ", nativeQuery = true)
    List<Course> calAverageScoreByCourse();
}
