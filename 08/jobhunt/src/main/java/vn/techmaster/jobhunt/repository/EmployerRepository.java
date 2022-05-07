package vn.techmaster.jobhunt.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class EmployerRepository {
    private List<Employer> employerList;

    public EmployerRepository() {
        employerList = new ArrayList<>(List.of(
                new Employer("EMP1", "Samsung", "ss@gmail.com", "0357456789","Hà Nội"),
                new Employer("EMP2", "Viettel", "vt@gmail.com", "0336578923","Hải Phòng"),
                new Employer("EMP3", "FPT", "fpt@gmail.com", "0987765234","Bắc Ninh"),
                new Employer("EMP4", "Vinamilk", "vnm@gmail.com", "0991204569","Bắc Ninh"),
                new Employer("EMP5", "VNPT", "vnpt@gmail.com", "088576495","Hà Nội")
        ));
    }
}
