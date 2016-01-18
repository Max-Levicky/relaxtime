package relaxtime.client.web.app;

import com.google.common.annotations.Beta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.Filter;
import java.io.IOException;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@SpringBootApplication
@ComponentScan({
        "relaxtime.lib.dao",
        "relaxtime.lib.model",
        "relaxtime.lib.service",
        "relaxtime.client.web.controller",
})
@ImportResource({
        "classpath*:/relaxtime/spring/api/*.xml",
        "classpath*:/relaxtime/spring/hibernate-active.xml",
        "classpath*:/relaxtime/hibernate/hibernate.cfg.xml"
})
@EnableConfigurationProperties({ ResourceProperties.class })
public class Config extends WebMvcConfigurerAdapter {
    @Autowired
    private ResourceProperties resourceProperties = new ResourceProperties();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Integer cachePeriod = resourceProperties.getCachePeriod();

        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/public/css/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/public/js/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/public/fonts/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/tmpl/**")
                .addResourceLocations("classpath:/public/tmpl/")
                .setCachePeriod(cachePeriod);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/public/img/")
                .setCachePeriod(cachePeriod);

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/public/index.html")
                .setCachePeriod(cachePeriod).resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath,
                                                   Resource location) throws IOException {
                        return location.exists() && location.isReadable() ? location
                                : null;
                    }
                });
    }
}