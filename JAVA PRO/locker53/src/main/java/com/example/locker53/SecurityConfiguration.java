package com.example.locker53;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration // методы класса являются источниками конфигурационных @Bean
@EnableWebSecurity // внутри этого класса будт настраиваться доступ к url контроллеров
public class SecurityConfiguration {

    @Bean
    public MyUserDetailsService getUserDetailsService()
    {
        return new MyUserDetailsService();
    }

    @Bean
    public static NoOpPasswordEncoder getEncoder()
    {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getEncoder());
        provider.setUserDetailsService(getUserDetailsService());
        return provider;
    }

    @Bean // используется для настройки авторизации
    // на доступ к конкретным url приложения
    public SecurityFilterChain getChain(HttpSecurity http) throws Exception {
        // h2 -> без аутентификации спринга
        // /index.html, /open -> без аутентификации спринга
        // /secure /logout.html -> с аутентификацией
        http
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        //.requestMatchers(antMatcher(toH2Console())).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/index.html")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/open")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/")).permitAll()
                                        // .requestMatchers(antMatcher(HttpMethod.GET, "/h2-console**")).permitAll()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/logout.html")).authenticated()
                                        .requestMatchers(antMatcher(HttpMethod.GET, "/secure")).authenticated()
                                        .requestMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("ADMIN")
                                        .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .httpBasic(Customizer.withDefaults())
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        ;

        return http.build();
    }

}
