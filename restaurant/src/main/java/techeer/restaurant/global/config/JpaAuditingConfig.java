package techeer.restaurant.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//원래 Application에 설정할 애너테이션들을 여기에 넣음 (@Configuration에 의해)

@EnableJpaAuditing //createdAt, updatedAt 설정
@Configuration //애플리케이션 실행될때 실행
public class JpaAuditingConfig {

}
