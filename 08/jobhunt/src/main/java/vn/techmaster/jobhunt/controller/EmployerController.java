package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.EmployerRequest;

import java.util.List;
import java.util.UUID;

@Controller
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepo;

    @GetMapping("/employers")
    public String getEmployerList(Model model) {
        List<Employer> employerList = employerRepo.getEmployers().values().stream().toList();
        model.addAttribute("employers", employerList);
        return "employers";
    }

    @GetMapping("/add-employer")
    public String getNewEmployerForm(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        return "add-employer";
    }

    @PostMapping("/add-employer")
    public String addNewEmployer(@ModelAttribute EmployerRequest empRequest, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Employer employer = new Employer();

            String uuid = UUID.randomUUID().toString();
            employer.setId(uuid);
            employer.setName(empRequest.getName());
            employer.setEmail(empRequest.getEmail());
            employer.setPhone(empRequest.getPhone());
            employer.setLocation(empRequest.getLocation());

            employerRepo.getEmployers().put(uuid, employer);
        }
        return "redirect:/employers";
    }
}
