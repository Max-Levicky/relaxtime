package relaxtime.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Max Levicky
 */
@Configuration
@ImportResource( {
        "classpath*:/relaxtime/spring/*-active.xml"
} )
//@ComponentScan( basePackages = "org.rest" )
//@PropertySource({ "classpath:rest.properties", "classpath:web.properties" })
public class AppConfig {
}
