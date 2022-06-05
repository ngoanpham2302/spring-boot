package vn.techmaster.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.springjpa.entity.StudentCourse;
import vn.techmaster.springjpa.entity.StudentCourseId;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {

}
