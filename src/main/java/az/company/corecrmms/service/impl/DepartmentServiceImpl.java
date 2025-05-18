package az.company.corecrmms.service.impl;

import az.company.corecrmms.dto.department.DepartmentRequestDto;
import az.company.corecrmms.dto.department.DepartmentResponseDto;
import az.company.corecrmms.entity.Department;
import az.company.corecrmms.exception.CommonException;
import az.company.corecrmms.exception.ExceptionEnums;
import az.company.corecrmms.mapper.DepartmentMapper;
import az.company.corecrmms.repository.DepartmentRepository;
import az.company.corecrmms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private static final String DUPLICATE_MESSAGE_TEMPLATE = "Department exist with argument %s : %s";


    @Override
    public List<DepartmentResponseDto> getAll() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentMapper.mapToResponseList(departmentList);
    }

    @Override
    public DepartmentResponseDto getById(String departmentId) {
        Department department = getDepartmentByIdElseThrow(departmentId);
        return departmentMapper.mapToResponse(department);
    }

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto departmentRequestDto) {
        validateDuplicationValueOfCreateDepartment(departmentRequestDto);
        Department department = departmentMapper.mapToEntity(departmentRequestDto);
        departmentRepository.save(department);
        return departmentMapper.mapToResponse(department);
    }

    @Override
    public DepartmentResponseDto update(String departmentId, DepartmentRequestDto departmentRequestDto) {
        Department department = getDepartmentByIdElseThrow(departmentId);
        validateDuplicationValueOfUpdateDepartment(department, departmentRequestDto);
        departmentMapper.updateDepartmentFromDto(departmentRequestDto, department);
        departmentRepository.save(department);
        return departmentMapper.mapToResponse(department);
    }


    private Department getDepartmentByIdElseThrow(String departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(
                        () -> new CommonException(ExceptionEnums.NOT_FOUND_EXCEPTION,
                                String.format("Department couldn't find with provided id %s", departmentId), null
                        )
                );
    }


    private void validateDuplicationValueOfUpdateDepartment(Department department, DepartmentRequestDto departmentRequestDto) {

        if (!department.getName().equals(departmentRequestDto.getName()) && departmentRepository.existsByName(departmentRequestDto.getName())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "name", departmentRequestDto.getName()), null);
        }

        if (!department.getShortName().equals(departmentRequestDto.getShortName()) &&
                departmentRepository.existsByShortName(departmentRequestDto.getShortName())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "shortName", departmentRequestDto.getShortName()), null);
        }

        if (!department.getHotCallNumber().equals(departmentRequestDto.getHotCallNumber()) &&
                departmentRepository.existsByHotCallNumber(departmentRequestDto.getHotCallNumber())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "hotCallNumber", departmentRequestDto.getHotCallNumber()), null);
        }
    }

    private void validateDuplicationValueOfCreateDepartment(DepartmentRequestDto departmentRequestDto) {
        if (departmentRepository.existsByName(departmentRequestDto.getName())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "name", departmentRequestDto.getName()), null);
        }

        if (departmentRepository.existsByShortName(departmentRequestDto.getShortName())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "shortName", departmentRequestDto.getShortName()), null);
        }

        if (departmentRepository.existsByHotCallNumber(departmentRequestDto.getHotCallNumber())) {
            throw new CommonException(ExceptionEnums.ALREADY_EXIST_EXCEPTION,
                    String.format(DUPLICATE_MESSAGE_TEMPLATE, "hotCallNumber", departmentRequestDto.getHotCallNumber()), null);
        }
    }

}
