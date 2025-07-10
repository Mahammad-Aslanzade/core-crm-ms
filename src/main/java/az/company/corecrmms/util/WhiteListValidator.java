package az.company.corecrmms.util;

import az.company.corecrmms.constant.Constants;
import org.springframework.util.AntPathMatcher;

public class WhiteListValidator {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    public static boolean isWhitelisted(String path) {
        for (String pattern : Constants.WHITE_LIST) {
            if (PATH_MATCHER.match(pattern, path)) {
                return true;
            }
        }
        return false;
    }

}