package pe.cibertec;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class MainConfig {

    @Bean
    public FilterRegistrationBean<Filter> jwtFilter(JwtMiddleware jwtMiddleware) {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtMiddleware);
        registrationBean.addUrlPatterns("/*"); // Aplicar a todas las rutas
        return registrationBean;
    }
}
