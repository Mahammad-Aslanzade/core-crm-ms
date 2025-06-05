package az.company.corecrmms.service;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.dto.job.JobRequestDto;
import az.company.corecrmms.entity.Job;

import java.util.List;

public interface JobService {

    List<JobDto> getAll();

    JobDto getById(String id);

    JobDto update(String id, JobRequestDto jobRequestDto);

    JobDto create(JobRequestDto jobRequestDto);

    void delete(String id);

    Job getEntityById(String id);
}
