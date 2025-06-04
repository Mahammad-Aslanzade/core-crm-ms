package az.company.corecrmms.service;

import az.company.corecrmms.dto.department.DepartmentRequestDto;
import az.company.corecrmms.dto.department.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDto> getAll();

    DepartmentResponseDto getById(String id);

    DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto);

    DepartmentResponseDto update(String departmentId, DepartmentRequestDto departmentRequestDto);
}
