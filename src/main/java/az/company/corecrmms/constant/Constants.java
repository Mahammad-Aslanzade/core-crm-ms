package az.company.corecrmms.constant;

public class Constants {

    public static final String X_API_KEY = "X-API-KEY";

    public static final String[] WHITE_LIST = {
            "/actuator/health/**",
            "/swagger-ui/**",
            "/swagger-resources/*",
            "/v3/api-docs/**"
    };

    public static final String NAME_PATTERN_REGEX = "^[A-Z][a-zA-ZÀ-ÿ'’-]{1,49}$";
    public static final String NAME_PATTERN_MSG = "Name must start with a capital letter and contain only letters, hyphens, or apostrophes.";

    public static final String SURNAME_PATTERN_REGEX = "^[A-Z][a-zA-ZÀ-ÿ'’-]{1,49}$";
    public static final String SURNAME_PATTERN_MSG = "Surname must start with a capital letter and contain only letters, hyphens, or apostrophes.";


    public static final String PASSWORD_PATTERN_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}:;\"',.<>?]).{8,64}$";

    public static final String PASSWORD_PATTERN_MSG =
            "Password must be 8–64 characters long and include at least one lowercase letter, one uppercase letter, one digit, and one special character.";

    public static final String VERIFICATION_EMAIL_SUBJECT = "User Account Verification";
    public static final String VERIFICATION_EMAIL_TEMPLATE_NAME = "email-verification";

}
