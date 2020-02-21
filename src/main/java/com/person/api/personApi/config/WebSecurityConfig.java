/*
 * package com.person.api.personApi.config;
 * 
 * import org.springframework.context.ApplicationContextAware; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter implements ApplicationContextAware {
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().
 * and().httpBasic(); }
 * 
 * protected void registerAuthentication(AuthenticationManagerBuilder
 * authManagerBuilder) throws Exception { authManagerBuilder
 * .inMemoryAuthentication() .withUser("root").password("root").roles("ADMIN");
 * }
 * 
 * }
 */
 
