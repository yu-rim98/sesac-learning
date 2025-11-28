package org.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                auth -> auth
                    .requestMatchers("/", "/info", "/login").permitAll() // 허용
                    .anyRequest().authenticated() // 로그인 필요
            )
            .formLogin(form -> form
                .loginPage("/login") // 커스텀 페이지 주소
                .defaultSuccessUrl("/dashboard", true) // 로그인 성공 시
                .failureUrl("/login") // 로그인 실패
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .permitAll()
            );

        return http.build();
    }

}
