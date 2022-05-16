package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.techmaster.jobhunt.request.EmployerRequest;
import vn.techmaster.jobhunt.service.EmployerService;

import javax.validation.Valid;

@Controller
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/employers")
    public String getEmployerList(Model model) {
        model.addAttribute("employers", employerService.getEmployerList());
        return "employers";
    }

    @GetMapping("/add-employer")
    public String getNewEmployerForm(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        return "add-employer";
    }

    @PostMapping("/add-employer")
    public String handleNewEmployerForm(@ModelAttribute @Valid EmployerRequest empRequest, BindingResult bindingResult,
                                        Model model, RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            return "add-employer";
        }
        employerService.createNewEmployer(empRequest);
        redirectAttr.addFlashAttribute("successMessage", "Thêm mới thành công!");
        redirectAttr.addFlashAttribute("empRequest", empRequest);
        return "redirect:/employers";
    }
}
