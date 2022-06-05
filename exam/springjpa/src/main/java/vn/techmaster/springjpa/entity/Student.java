package vn.techmaster.springjpa.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Câu 19, 20

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> courses;
}
