package com.zack.api.infra.security;


import com.zack.api.filters.JwtFilter;
import com.zack.api.filters.OnlyUnAuthenticatedUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable).sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ).authorizeHttpRequests(auth ->
                auth.requestMatchers("/adm/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/user/update/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/user/validate").hasRole("VERIFY_MAIL")
                        .requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole("ADMIN", "USER", "VERIFY_MAIL", "BANNED")
                        .requestMatchers(HttpMethod.PUT, "/user/change/password/forgotten").permitAll()
                        .anyRequest().permitAll()
        ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public FilterRegistrationBean<OnlyUnAuthenticatedUsers> onlyUnAuthenticatedUsersFilterRegistrationBean() {
        FilterRegistrationBean<OnlyUnAuthenticatedUsers> registration = new FilterRegistrationBean<>();
        registration.setFilter(new OnlyUnAuthenticatedUsers());
        registration.addUrlPatterns("/user/login");
        registration.addUrlPatterns("/user/register");

        return registration;
    }

}
