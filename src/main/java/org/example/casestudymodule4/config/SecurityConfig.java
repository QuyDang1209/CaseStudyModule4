package org.example.casestudymodule4.config;

import org.example.casestudymodule4.config.impl.CustomAccessDeniedHandler;
import org.example.casestudymodule4.config.impl.JwtAuthenticationTokenFilter;
import org.example.casestudymodule4.config.impl.RestAuthenticationEntryPoint;
import org.example.casestudymodule4.config.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/**").permitAll()
//
//                        .requestMatchers("/static/**").permitAll()
//                        .requestMatchers("/**").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/player/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/player/**").permitAll()
//                        .requestMatchers(HttpMethod.PUT,"/api/player/**").permitAll()
//                        .requestMatchers(HttpMethod.DELETE,"/api/player/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/playertracking/**").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/playertracking/**").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/coach_tracking/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/coach_tracking/**").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/coaches/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/coaches/**").permitAll()
//                        .requestMatchers(HttpMethod.PUT,"/api/coaches/**").permitAll()
//                        .requestMatchers(HttpMethod.DELETE,"/api/coaches/**").permitAll()

                )
                .exceptionHandling(customizer -> customizer.accessDeniedHandler(customAccessDeniedHandler()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
