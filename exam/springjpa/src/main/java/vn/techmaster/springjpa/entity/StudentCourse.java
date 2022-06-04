package vn.techmaster.springjpa.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Câu 19

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {
    @EmbeddedId
    private StudentCourseId studentCourseId;

    private int score;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public void setStudentCourseId(StudentCourseId studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    // Validate: Score must be >= 0 and <= 10
    public void setScore(int score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Score can not be smaller than 0 and greater than 10");
        }
        this.score = score;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
