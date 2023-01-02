package group.ship.blackshipstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(info());
    }

    @Bean
    Info info(){
        return new Info()
                .title("Black ship store")
                .version("1.0.0");
    }
}
