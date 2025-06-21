package az.company.corecrmms.filter;

import az.company.corecrmms.exception.ExceptionEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class ApiKeyFilter implements Filter {

    private String apikey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String apiKeyInHeader = request.getHeader("X-API-KEY");

        if (!Objects.equals(apiKeyInHeader, apikey)) {
            log.warn(
                    "[Unauthorized API Access] Invalid API key received from IP: {}, Path: {}, Provided-Key: {}",
                    request.getRemoteAddr(), request.getRequestURI(), apiKeyInHeader
            );
            returnExceptionResponse(response, ExceptionEnum.INVALID_API_KEY_EXCEPTION);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Map<String, Object> generateExceptionDto(ExceptionEnum exceptionEnum) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("code", exceptionEnum.getExceptionCode());
        errors.put("messages", List.of(exceptionEnum.getDefaultMessage()));
        return errors;
    }

    @SneakyThrows
    private void returnExceptionResponse(HttpServletResponse response, ExceptionEnum exceptionEnum) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(exceptionEnum.getStatus().value());
        response.getWriter().write(objectMapper.writeValueAsString(generateExceptionDto(exceptionEnum)));
    }
}
