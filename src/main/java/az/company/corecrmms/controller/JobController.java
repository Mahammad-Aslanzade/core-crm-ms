package az.company.corecrmms.controller;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.dto.job.JobRequestDto;
import az.company.corecrmms.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public JobDto getJobById(@PathVariable String id) {
        return jobService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobDto createJob(@RequestBody @Valid JobRequestDto jobRequestDto) {
        return jobService.create(jobRequestDto);
    }

    @PutMapping("/{id}")
    public JobDto updateJobById(@PathVariable String id, @RequestBody @Valid JobRequestDto jobRequestDto) {
        return jobService.update(id, jobRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        jobService.delete(id);
    }
}
