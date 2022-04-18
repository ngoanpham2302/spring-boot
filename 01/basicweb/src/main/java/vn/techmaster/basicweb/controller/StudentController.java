package vn.techmaster.basicweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.basicweb.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> studentList;

    public StudentController() {
        studentList = new ArrayList<>();
        studentList.add(new Student(123, "Nguyễn Văn An", "Công nghệ thông tin", 7.8));
        studentList.add(new Student(456, "Phạm Hải Yến", "Tài chính ngân hàng", 8.5));
        studentList.add(new Student(789, "Võ Hoàng Minh", "Kiểm toán kế toán", 7.9));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentList;
    }

    @PostMapping
    public List<Student> addNewStudent(@RequestBody Student student) {
        studentList.add(student);
        return studentList;
    }
}
