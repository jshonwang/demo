package com.example.demo.configuration;


import com.example.demo.handler.AuthenticationFailHandler;
import com.example.demo.handler.AuthenticationSuccessHandler;
import com.example.demo.service.impl.DatabaseUserDetailService;
import com.example.demo.utils.JwtAuthenticationFilter;

import com.example.demo.utils.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Configuration
    public static class MySecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("databaseUserDetailService")
        private DatabaseUserDetailService userDetailsService;

        @Autowired
        @Qualifier("authenticationSuccessHandler")
        private AuthenticationSuccessHandler successHandler;

        @Autowired
        @Qualifier("authenticationFailHandler")
        private AuthenticationFailHandler failHandler;

        @Autowired
        @Qualifier("authenticationEntryPointImpl")
        private AuthenticationEntryPoint entryPoint;

        @Bean
        public JwtAuthenticationFilter getJwtAuthenticationFilter(){
            return new JwtAuthenticationFilter();
        }

        /**
         * 拦截请求
         * @param http
         * @throws Exception
         */
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(getJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/user/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginProcessingUrl("/user/login")
                    .successHandler(successHandler)
                    .failureHandler(failHandler)
                    .and().exceptionHandling().authenticationEntryPoint(entryPoint);
        }

        /**
         * 用户认证
         * @param auth
         * @throws Exception
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(new MyPasswordEncoder());
        }
    }
}
