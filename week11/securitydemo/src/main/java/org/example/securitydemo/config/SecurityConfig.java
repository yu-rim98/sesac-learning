package org.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                auth -> auth
                    .requestMatchers("/", "/info", "/login", "/h2-console/**").permitAll() // 허용
                    .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 권한만 접근 가능
                    .requestMatchers("/dashboard/**")
                    .hasAnyRole("USER", "ADMIN") // USER, ADMIN 접근 가능
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
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/access-denied")
            );

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//            .username("user")
//            .password("{noop}1234")
//            .roles("USER")
//            .build();
//
//        UserDetails admin = User.builder()
//            .username("admin")
//            .password("{noop}admin")
//            .roles("USER", "ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
