package com.trexis.employeeallocation.security;

import com.trexis.employeeallocation.service.UserDetailsServiceImpl;
import com.trexis.employeeallocation.util.JwtAuthenticationEntryPoint;
import com.trexis.employeeallocation.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // Yeah, we need some password encryption here so passwords don't fly around in plain text
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This is where Spring Boot gets the authentication manager bean
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Setting up the userDetailsService and password encoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // The main security config. We're disabling CSRF (because this is stateless) and setting role-based rules
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/auth/login", "/api/auth/register").permitAll() // Anyone can register or login
            .antMatchers("/api/managers/**").hasAnyRole("ADMIN", "MANAGER") // Only admins or managers can access manager endpoints
            .antMatchers("/api/departments/**").hasRole("ADMIN") // Only admins can access department stuff
            .antMatchers("/api/managers/no-reports").hasRole("ADMIN") // Admins can list managers without reports
            .anyRequest().authenticated() // Everything else needs to be authenticated
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint) // Custom handling for unauthorized access
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // We don't want sessions

        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // Adding our JWT token filter
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter(jwtTokenUtil, userDetailsService);
    }
}
