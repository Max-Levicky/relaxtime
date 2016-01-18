package relaxtime.api.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableWebMvc
@ImportResource({
        "classpath*:/relaxtime/spring/api/applicationContext.xml",
        "classpath*:/relaxtime/spring/api/spring-security.xml",
        "classpath*:/relaxtime/spring/hibernate-active.xml",
        "classpath*:/relaxtime/hibernate/hibernate.cfg.xml",
})
public class Config {
//    @Bean
//    public FilterRegistrationBean headersFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeadersFilter());
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean securityFilterChain(@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
//        registration.setOrder(10);
//        registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
//        return registration;
//    }
}
