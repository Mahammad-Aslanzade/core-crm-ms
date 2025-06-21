package az.company.corecrmms.controller;

import az.company.corecrmms.dto.department.DepartmentRequestDto;
import az.company.corecrmms.dto.department.DepartmentResponseDto;
import az.company.corecrmms.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
@Validated
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto getDepartmentByNo(@PathVariable String id) {
        return departmentService.getById(id);
    }

    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody @Valid DepartmentRequestDto departmentRequestDto) {
        return departmentService.create(departmentRequestDto);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable String id, @RequestBody @Valid DepartmentRequestDto departmentRequestDto) {
        return departmentService.update(id, departmentRequestDto);
    }

}
