package com.mclearn.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean(name = "SpringSecurityFilterChain")
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity serverHttpSecurity) throws Exception {
        serverHttpSecurity.csrf(c -> c.disable()).authorizeRequests()
                .requestMatchers((new String[]{"/swagger-ui/**", "/auth/**",
                "/v3/api-docs/**"}))
                .permitAll()
                .anyRequest()
                .authenticated();
        //serverHttpSecurity.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return serverHttpSecurity.build();
    }
}
