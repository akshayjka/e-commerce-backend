package com.example.E_Commerce.register.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class storeSecurityConfig extends WebSecurityConfiguration implements WebMvcConfigurer {

    private jwtAuthenticationFIlter jwtAuthenticationFilter;
        private  UserDetailsService userDetailsService;
    
          public void StoreSecurityConfig(jwtAuthenticationFIlter jwtAuthenticationFilter, UserDetailsService userDetailsService) {
            this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    // @SuppressWarnings({ "removal", "deprecation" })
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF if not using cookies for authentication
            .cors() // Enable CORS support
            .and()
            .authorizeRequests()
                .requestMatchers("/api/user").permitAll() // Require authentication for POST
                .requestMatchers("/login/user").permitAll()
                .anyRequest().permitAll() // Allow other endpoints without authentication
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            // .httpBasic(); // Enable Basic Authentication
        // return http.build();
        // http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter
        return http.build();
    }

    // @Bean
    // public UserDetailsService users() {
    //     return new InMemoryUserDetailsManager(
    //         User.withDefaultPasswordEncoder()
    //             .username("test")
    //             .password("test@123")
    //             .roles("USER")
    //             .build()
    //     );
    // }

    //    @Autowired
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(userDetailsService);
    // }

    //    @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    //     return authenticationConfiguration.getAuthenticationManager();
    // }
    

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Angular app origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow all relevant methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (for Basic Auth headers)
    }
}
