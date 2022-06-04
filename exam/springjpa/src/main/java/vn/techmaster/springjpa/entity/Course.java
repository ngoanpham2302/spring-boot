package vn.techmaster.springjpa.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Câu 19

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> students;

}
