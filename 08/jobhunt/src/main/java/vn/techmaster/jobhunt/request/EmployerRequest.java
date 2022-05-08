package vn.techmaster.jobhunt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequest {
    @NotEmpty(message = "{name.empty}")
    private String name;

    @NotEmpty(message = "{email.empty}")
    @Email(message = "{email.pattern}")
    private String email;

    // @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "{phone.pattern}")
    @NotEmpty(message = "{phone.empty}")
    private String phone;

    @NotEmpty(message = "{location.empty}")
    private String location;
}
