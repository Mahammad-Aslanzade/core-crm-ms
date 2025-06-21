package az.company.corecrmms.dto.user;

import az.company.corecrmms.dto.department.DepartmentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String internalNumber;
    private DepartmentResponseDto department;
    private BigDecimal salary;
}
