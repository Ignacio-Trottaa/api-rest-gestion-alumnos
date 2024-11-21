package edu.campus.campusLeopoldoMarechal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // aplica CORS a todas las URLs
                    .allowedOrigins("*")    // permite acceso desde cualquier origen
                    .allowedMethods("*");   // metodos
    }
}
