package az.company.corecrmms.dto.department;

import az.company.corecrmms.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponseDto extends BaseResponse {
    private String name;
    private String shortName;
    private String address;
    private String hotCallNumber;
}
