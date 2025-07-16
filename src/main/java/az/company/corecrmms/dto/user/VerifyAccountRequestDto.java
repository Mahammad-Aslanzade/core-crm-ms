package az.company.corecrmms.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyAccountRequestDto {
    private String email;
    private String code;
}