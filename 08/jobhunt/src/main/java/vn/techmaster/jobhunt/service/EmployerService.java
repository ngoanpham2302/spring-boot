package vn.techmaster.jobhunt.service;

import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.request.EmployerRequest;

import java.util.List;

public interface EmployerService {
    List<Employer> getEmployerList();

    void createNewEmployer(EmployerRequest empRequest);
}
