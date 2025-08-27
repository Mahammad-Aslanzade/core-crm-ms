package az.company.corecrmms.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static az.company.corecrmms.constant.Constants.VERIFICATION_CODE_PATTERN_MSG;
import static az.company.corecrmms.constant.Constants.VERIFICATION_CODE_REGEX;

@Getter
@Setter
public class VerifyAccountRequestDto {

    @Email
    private String email;

    @Pattern(regexp = VERIFICATION_CODE_REGEX, message = VERIFICATION_CODE_PATTERN_MSG)
    private String code;
}