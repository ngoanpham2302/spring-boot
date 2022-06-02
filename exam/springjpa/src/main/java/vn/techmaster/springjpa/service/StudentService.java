package vn.techmaster.springjpa.service;

import java.util.List;
import java.util.Map;

import vn.techmaster.springjpa.entity.Student;

public interface StudentService {
    Map<String, List<Student>> getStudentByCourse();

    List<Student> searchByCourse();
}
