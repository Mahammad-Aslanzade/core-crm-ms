package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.entity.Job;
import az.company.corecrmms.exception.CommonException;
import az.company.corecrmms.exception.ExceptionEnums;
import az.company.corecrmms.mapper.JobMapper;
import az.company.corecrmms.repository.JobRepository;
import az.company.corecrmms.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public List<JobDto> getAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobMapper.mapToDtoList(jobs);
    }

    @Override
    public JobDto getById(String id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new CommonException(ExceptionEnums.NOT_FOUND_EXCEPTION,
                        String.format("Job not found with provided id : %s", id)
                )
        );
        return jobMapper.mapToDto(job);
    }
}
