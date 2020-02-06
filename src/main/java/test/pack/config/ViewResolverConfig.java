package test.pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
public class ViewResolverConfig {
    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix ("/WEB-INF/pages/");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }

}
