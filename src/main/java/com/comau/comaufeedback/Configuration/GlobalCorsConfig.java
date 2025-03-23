package com.comau.comaufeedback.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("*")); // Allow all origins
        config.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
        config.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers
        config.setAllowCredentials(true); // Allow cookies/auth headers (optional)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply CORS to all paths

        return new CorsFilter(source);
    }
}
