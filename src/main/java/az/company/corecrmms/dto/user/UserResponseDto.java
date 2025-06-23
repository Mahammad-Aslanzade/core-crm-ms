package az.company.corecrmms.dto.user;

import az.company.corecrmms.dto.department.DepartmentResponseDto;
import az.company.corecrmms.dto.job.JobDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String surname;
    private String email;
    private String internalNumber;
    private String currentJobId;
    private List<JobDto> jobs;
}
