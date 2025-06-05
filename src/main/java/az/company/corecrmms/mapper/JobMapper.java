package az.company.corecrmms.mapper;

import az.company.corecrmms.dto.job.JobDto;
import az.company.corecrmms.dto.job.JobRequestDto;
import az.company.corecrmms.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface JobMapper {

    List<JobDto> mapToDtoList(List<Job> jobs);

    JobDto mapToDto(Job job);

    Job mapToEntity(JobRequestDto jobRequestDto);

    @Mapping(source = "departmentId", target = "department.id")
    void updateEntityFromDto(JobRequestDto jobRequestDto, @MappingTarget Job job);
}
