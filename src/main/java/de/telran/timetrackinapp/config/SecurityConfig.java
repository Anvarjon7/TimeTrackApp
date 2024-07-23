package de.telran.timetrackinapp.config;

import org.springframework.context.annotation.Configuration;

//package de.telran.timetrackinapp.config;
//
////import de.telran.timetrackinapp.security.CustomAuthenticationProvider;
////import de.telran.timetrackinapp.security.FirebaseAuthenticationFilter;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.AuthenticationProvider;
////import org.springframework.security.authentication.ProviderManager;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.config.http.SessionCreationPolicy;
//import de.telran.timetrackinapp.security.FirebaseService;
//import de.telran.timetrackinapp.security.FirebaseAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
@Configuration
public class SecurityConfig {

//
//    private final FirebaseService firebaseService;
//
//    public SecurityConfig(FirebaseService firebaseService) {
//        this.firebaseService = firebaseService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
//        FirebaseAuthenticationFilter firebaseAuthenticationFilter = new FirebaseAuthenticationFilter(firebaseService);
//        firebaseAuthenticationFilter.setAuthenticationManager(authenticationManager);
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/api/users/register/**", "/api/users/current-user/**", "/api/users/current/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .addFilterBefore(firebaseAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public FirebaseAuthenticationFilter firebaseAuthenticationFilter() {
//        return new FirebaseAuthenticationFilter(firebaseService);
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManager.class);
//    }
//
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        return new CustomAuthenticationProvider();
////    }
//
//    @Bean
//    public  passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
