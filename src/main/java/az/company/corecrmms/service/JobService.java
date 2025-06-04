package az.company.corecrmms.service;

import az.company.corecrmms.dto.job.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> getAll();

    JobDto getById(String id);
}
