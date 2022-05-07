package vn.techmaster.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Applicant {
    private String id;
    private String name;
    private String email;
    private String phone;
}
