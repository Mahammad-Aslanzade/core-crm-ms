package az.company.corecrmms.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static az.company.corecrmms.constant.Constants.NAME_PATTERN_MSG;
import static az.company.corecrmms.constant.Constants.NAME_PATTERN_REGEX;
import static az.company.corecrmms.constant.Constants.PASSWORD_PATTERN_MSG;
import static az.company.corecrmms.constant.Constants.PASSWORD_PATTERN_REGEX;
import static az.company.corecrmms.constant.Constants.SURNAME_PATTERN_MSG;
import static az.company.corecrmms.constant.Constants.SURNAME_PATTERN_REGEX;


@Getter
@Setter
public class UserCreateDto {

    @NotNull
    @Pattern(regexp = NAME_PATTERN_REGEX, message = NAME_PATTERN_MSG)
    private String name;

    @NotNull
    @Pattern(regexp = SURNAME_PATTERN_REGEX, message = SURNAME_PATTERN_MSG)
    private String surname;

    @NotNull
    private String currentJobId;

    @NotNull
    @Pattern(regexp = PASSWORD_PATTERN_REGEX, message = PASSWORD_PATTERN_MSG)
    private String password;
}
