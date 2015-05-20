package relaxtime.api.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import relaxtime.api.filter.HeadersFilter;

import javax.servlet.Filter;
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
//        @Bean
//        public FilterRegistrationBean headersFilter() {
//                FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeadersFilter());
//                registrationBean.setOrder(1);
//                return registrationBean;
//        }
        @Bean
        public FilterRegistrationBean securityFilterChain(@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
                FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
                registration.setOrder(10);
                registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
                return registration;
        }
}
