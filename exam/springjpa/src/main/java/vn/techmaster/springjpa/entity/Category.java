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
@Entity(name = "category")
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Khi một Category bị xoá, thì không được phép xoá Product, mà chỉ set thuộc tính Category của Product là null.
    @PreRemove
    private void preRemove() {
        for (Product pro : products) {
            pro.setCategory(null);
        }
    }

}
