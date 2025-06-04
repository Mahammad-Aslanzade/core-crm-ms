package az.company.corecrmms.dto.job;

import az.company.corecrmms.dto.BaseResponse;
import az.company.corecrmms.dto.department.DepartmentResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDto extends BaseResponse {
    private String title;
    private DepartmentResponseDto department;
}
