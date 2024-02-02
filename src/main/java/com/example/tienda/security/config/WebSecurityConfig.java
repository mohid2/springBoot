package com.example.tienda.security.config;


import com.example.tienda.security.entity.AuthorityName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(autRequest->
                        autRequest.requestMatchers(publicEndpoints()).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/laptops")).hasRole(AuthorityName.ADMIN.name())
                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).hasRole(AuthorityName.USER.name())
                                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())
                .httpBasic();
        return http.build();
    }

    private RequestMatcher publicEndpoints(){
        return new OrRequestMatcher(
                new AntPathRequestMatcher("/v3/api-docs/**"),
                new AntPathRequestMatcher("/api/auth/**")
        );
    }
}
