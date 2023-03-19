package chanyoung.GoodNightHackathon.global;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html
@Configuration
public class Swagger {
    @Bean
    public OpenAPI hackathonOpenAPI() {
        return new OpenAPI().info( new Info()
                .title("Hackathon API")
                .description("Restaurant, Review API 명세서입니다.")
                .version("v0.0.1") );
    }

}
