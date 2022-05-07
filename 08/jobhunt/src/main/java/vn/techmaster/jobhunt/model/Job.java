package vn.techmaster.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private String id;
    private String title;
    private String location;
    private int salary;
    private String email_to;
}
