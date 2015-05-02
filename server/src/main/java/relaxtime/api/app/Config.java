package relaxtime.api.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ImportResource({
        "classpath*:/relaxtime/spring/api/applicationContext.xml",
        "classpath*:/relaxtime/spring/api/spring-security.xml",
        "classpath*:/relaxtime/spring/hibernate-active.xml",
        "classpath*:/relaxtime/hibernate/hibernate.cfg.xml",
})
public class Config {
}
