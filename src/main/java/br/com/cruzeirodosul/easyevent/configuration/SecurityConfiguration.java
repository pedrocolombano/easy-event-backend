package br.com.cruzeirodosul.easyevent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) -> {
            request.requestMatchers(HttpMethod.POST, "/users").permitAll()
                    .anyRequest().permitAll();
        }).csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }

}
