package vn.techmaster.jobhunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.EmployerRequest;

import java.util.List;
import java.util.UUID;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepo;

    @Override
    public List<Employer> getEmployerList() {
         return employerRepo.getEmployers().values().stream().toList();
    }

    @Override
    public void createNewEmployer(EmployerRequest empRequest) {
        Employer employer = new Employer();

        String uuid = UUID.randomUUID().toString();
        employer.setId(uuid);
        employer.setName(empRequest.getName());
        employer.setEmail(empRequest.getEmail());
        employer.setPhone(empRequest.getPhone());
        employer.setLocation(empRequest.getLocation());

        employerRepo.getEmployers().put(uuid, employer);
    }
}
