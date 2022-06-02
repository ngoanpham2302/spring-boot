package vn.techmaster.springjpa.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Câu 18

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tag")
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Product> products;
}
