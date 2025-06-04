package az.company.corecrmms.dto.department;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDto {

    @NotNull
    private String name;
    @NotNull
    private String shortName;
    @NotNull
    private String address;
    @NotNull
    private String hotCallNumber;
}
