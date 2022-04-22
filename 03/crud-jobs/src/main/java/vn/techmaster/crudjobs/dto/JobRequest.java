package vn.techmaster.crudjobs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.techmaster.crudjobs.model.Location;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobRequest {
    private String title;
    private String description;
    private Location location;
    private int min_salary;
    private int max_salary;
    private String email_to;
}
