package vn.techmaster.springjpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class StudentCourseId implements Serializable {
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "course_id")
    private long courseId;
}
