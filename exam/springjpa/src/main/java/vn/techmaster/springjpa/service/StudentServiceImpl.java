package vn.techmaster.springjpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.springjpa.entity.Course;
import vn.techmaster.springjpa.entity.Student;
import vn.techmaster.springjpa.repository.CourseRepository;
import vn.techmaster.springjpa.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    // Trả về liệt kê sinh viên tham gia từng môn học Map<String, List<Student>>:
    // key là tên môn học, value là danh sách sinh viên đăng ký

    @Override
    public Map<String, List<Student>> getStudentsByCourse() {
        // Lấy danh sách toàn bộ môn học
        List<Course> courseList = courseRepo.findAll();

        Map<String, List<Student>> courseMap = new HashMap<>();

        for (Course course : courseList) {
            String courseName = course.getName();
            courseMap.put(courseName, studentRepo.getStudentsByCourse(courseName));
        }

        return courseMap;
    }

    // Liệt kê danh sách sinh viên học math nhưng không học music
    @Override
    public List<Student> searchByCourse() {
        return studentRepo.searchByCourse();
    }
}
