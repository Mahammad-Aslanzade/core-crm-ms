package az.company.corecrmms.config;

import az.company.corecrmms.constant.Constants;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Core-CRM-MS")
                        .version("1.0")
                )
                .addSecurityItem(new SecurityRequirement().addList(Constants.X_API_KEY))
                .components(new Components()
                        .addSecuritySchemes(Constants.X_API_KEY, new SecurityScheme()
                                .name(Constants.X_API_KEY)
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)));
    }

}
