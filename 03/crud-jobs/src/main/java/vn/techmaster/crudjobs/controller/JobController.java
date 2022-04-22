package vn.techmaster.crudjobs.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import vn.techmaster.crudjobs.dto.JobRequest;
import vn.techmaster.crudjobs.model.Job;
import vn.techmaster.crudjobs.model.Location;

@RestController
@RequestMapping("/job")
public class JobController {
    private List<Job> jobList;

    public JobController() {
        jobList = new ArrayList<>();
        jobList.add(new Job("JOB11", "Frontend Developer", "Familiar with HTML, CSS, JS", Location.HAI_PHONG, 350, 1500,
                "abc@gmail.com"));
        jobList.add(new Job("JOB12", "Business Analyst", "Transfer requirement to IT team", Location.DA_NANG, 450, 2200,
                "def@gmail.com"));
        jobList.add(new Job("JOB13", "Backend Developer", "Familiar with Golang, Java", Location.HO_CHI_MINH,
                700, 2750,
                "efg@gmail.com"));
        jobList.add(new Job("JOB14", "DevOps Engineer", "Experience with Kubernetes", Location.HA_NOI,
                1000, 3200,
                "hik@gmail.com"));
        jobList.add(new Job("JOB15", "PHP Developer", "Familiar with PHP", Location.HAI_PHONG,
                750, 1800,
                "lmn@gmail.com"));
    }

    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobList;
    }

    // Get job by id
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") String id) {
        for (Job job : jobList) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found");
    }

    // Create new job
    @PostMapping
    public ResponseEntity<Job> createNewJob(@RequestBody JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.getTitle(), jobRequest.getDescription(), jobRequest.getLocation(),
                jobRequest.getMin_salary(), jobRequest.getMax_salary(), jobRequest.getEmail_to());

        jobList.add(newJob);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJob);
    }

    // Update job by id
    @PutMapping("/{id}")
    public Job updateJobById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
        for (Job job : jobList) {
            if (job.getId().equals(id)) {
                job.setTitle(jobRequest.getTitle());
                job.setDescription(jobRequest.getDescription());
                job.setLocation(jobRequest.getLocation());
                job.setMin_salary(jobRequest.getMin_salary());
                job.setMax_salary(jobRequest.getMax_salary());
                job.setEmail_to(jobRequest.getEmail_to());
                return job;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found");
    }

    // Delete job
    @DeleteMapping("/{id}")
    public Job deleteJob(@PathVariable("id") String id) {
        for (Job job : jobList) {
            if (job.getId().equals(id)) {
                jobList.remove(job);
                return job;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found");
    }

    // Sort jobs by location
    @GetMapping("/sortbylocation")
    public List<Job> sortJobByLocation() {
        return jobList.stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());

        // jobList.sort(Comparator.comparing(Job::getLocation));
        // return jobList;
    }

    // Find job by salary
    @GetMapping("/salary/{salary}")
    public List<Job> findJobBySalary(@PathVariable("salary") int salary) {
        return jobList.stream().filter(job -> (job.getMin_salary() <= salary && job.getMax_salary() >= salary))
                .collect(Collectors.toList());
    }

    // Find job by keyword (title or description)
    @GetMapping("/keyword/{keyword}")
    public List<Job> findJobByKeyword(@PathVariable("keyword") String keyword) {
        String keyLowerCase = keyword.toLowerCase();
        return jobList.stream()
                .filter(job -> (job.getTitle().toLowerCase().contains(
                        keyLowerCase)
                        || job.getDescription().toLowerCase().contains(
                                keyLowerCase)))
                .collect(Collectors.toList());

    }

    // Find job by location and keyword
    @GetMapping("/query")
    public List<Job> findJobByLocationAndKeyword(@RequestParam("location") Location location,
            @RequestParam("keyword") String keyword) {
        List<Job> result = new ArrayList<>();
        String keyLowerCase = keyword.toLowerCase();

        result = jobList.stream().filter(job -> job.getLocation().equals(location) && (job.getTitle().toLowerCase()
                .contains(
                        keyLowerCase)
                || job.getDescription().toLowerCase().contains(
                        keyLowerCase)))
                .collect(Collectors.toList());

        return result;
    }
}
