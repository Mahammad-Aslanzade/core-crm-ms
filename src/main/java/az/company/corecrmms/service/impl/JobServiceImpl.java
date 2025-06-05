package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.dto.job.JobRequestDto;
import az.company.corecrmms.entity.Department;
import az.company.corecrmms.entity.Job;
import az.company.corecrmms.exception.CommonException;
import az.company.corecrmms.exception.ExceptionEnums;
import az.company.corecrmms.mapper.JobMapper;
import az.company.corecrmms.repository.JobRepository;
import az.company.corecrmms.service.DepartmentService;
import az.company.corecrmms.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final DepartmentService departmentService;

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

    @Override
    public JobDto create(JobRequestDto jobRequestDto) {
        Job job = jobMapper.mapToEntity(jobRequestDto);
        Department department = departmentService.getEntityById(jobRequestDto.getDepartmentId());
        job.setDepartment(department);
        jobRepository.save(job);
        return jobMapper.mapToDto(job);
    }


    @Override
    public JobDto update(String id, JobRequestDto jobRequestDto) {
        Job job = getEntityById(id);
        Department department = departmentService.getEntityById(jobRequestDto.getDepartmentId());
        jobMapper.updateEntityFromDto(jobRequestDto, job);
        job.setDepartment(department);
        jobRepository.save(job);
        return jobMapper.mapToDto(job);
    }

    @Override
    public void delete(String id) {
        Job job = getEntityById(id);
        jobRepository.delete(job);
    }

    @Override
    public Job getEntityById(String id) {
        return jobRepository.findById(id).orElseThrow(
                () -> new CommonException(
                        ExceptionEnums.NOT_FOUND_EXCEPTION, String.format("Job not found with provided id: %s", id)
                )
        );
    }

}
