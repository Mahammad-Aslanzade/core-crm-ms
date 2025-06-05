package az.company.corecrmms.dto.job;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDto {

    @NotNull
    private String title;
    @NotNull
    private String departmentId;
}
