package com.gantner.demo.bank.ibanvalidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.gantner.demo.iban.ibanvalidator")
/**
 * Spring Configuration class
 * @author Stefan Gantner
 */
public class AppConfig {
    @Bean
    //Allow frontend through Cors
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/validate-iban").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
