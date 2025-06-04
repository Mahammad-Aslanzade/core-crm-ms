package az.company.corecrmms.mapper;

import az.company.corecrmms.dto.department.DepartmentRequestDto;
import az.company.corecrmms.dto.department.DepartmentResponseDto;
import az.company.corecrmms.entity.Department;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
    List<DepartmentResponseDto> mapToResponseList(List<Department> department);

    DepartmentResponseDto mapToResponse(Department department);

    Department mapToEntity(DepartmentRequestDto departmentRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDepartmentFromDto(DepartmentRequestDto dto, @MappingTarget Department entity);
}
