package relaxtime.client.web.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({
        "relaxtime.api.controller",
        "relaxtime.lib.dao",
        "relaxtime.lib.model",
        "relaxtime.lib.service"
})
@ImportResource({
        "classpath*:/relaxtime/spring/api/*.xml",
        "classpath*:/relaxtime/spring/hibernate-active.xml",
        "classpath*:/relaxtime/hibernate/hibernate.cfg.xml"
})
public class Config {
}
