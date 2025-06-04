package az.company.corecrmms.controller;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs(){
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public JobDto getJobById(@PathVariable String id){
        return jobService.getById(id);
    }
}
