package vn.techmaster.springjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import vn.techmaster.springjpa.repository.CourseRepository;
import vn.techmaster.springjpa.repository.StudentRepository;

@DataJpaTest
@Sql(scripts = "/sample-data.sql")
public class StudentCourseTest {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    // Test tính điểm trung bình một môn bất kỳ: math
    @Test
    public void testMethod3() {
        double expectedMathAvgScore = 7.6;
        double actualMathAvgScore = courseRepo.calAverageScoreByCourse("math");
        assertEquals(expectedMathAvgScore, actualMathAvgScore);
    }
}
