package vn.techmaster.labdidemo.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Engine {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
