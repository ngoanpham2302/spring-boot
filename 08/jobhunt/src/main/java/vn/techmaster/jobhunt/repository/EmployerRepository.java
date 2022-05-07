package vn.techmaster.jobhunt.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import java.util.concurrent.ConcurrentHashMap;

@Repository
@Getter
@Setter
public class EmployerRepository {
    private ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository() {
        employers = new ConcurrentHashMap<>();
        employers.put("EMP1", new Employer("EMP1", "Samsung", "ss@gmail.com", "0357456789","Hà Nội"));
        employers.put("EMP2", new Employer("EMP1", "Samsung", "ss@gmail.com", "0357456789","Hà Nội"));
        employers.put("EMP3",new Employer("EMP3", "FPT", "fpt@gmail.com", "0987765234","Bắc Ninh"));
        employers.put("EMP4", new Employer("EMP4", "Vinamilk", "vnm@gmail.com", "0991204569","Bắc Ninh"));
        employers.put("EMP5", new Employer("EMP5", "VNPT", "vnpt@gmail.com", "0885764952","Hà Nội"));
    }
}
