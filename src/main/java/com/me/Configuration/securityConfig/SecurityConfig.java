package com.me.Configuration.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.httpBasic(Customizer.withDefaults()).authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/api/owner/**").permitAll()
                                .anyRequest().authenticated()

                ).formLogin(Customizer.withDefaults())
                .csrf(Customizer.withDefaults());
        return http.build();
    }
}
