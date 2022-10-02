package com.bill.java.billproject.Config;

import com.bill.java.billproject.Filter.JwtFilter;
import com.bill.java.billproject.Service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final MemberDetailService service;
    private final JwtFilter filter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity https) throws Exception{
        AuthenticationManagerBuilder builder=https.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(service);
        return builder.build();
    }


    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity https) throws Exception{
        https.csrf().disable();
        https.authorizeRequests().antMatchers("/save","/login").permitAll().and()
                .authorizeRequests().antMatchers("/").hasRole("MEMBER").and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        https.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return https.build();
    }
}
