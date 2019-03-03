package pl.sda.spring.data.demomongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("nimda")
                        .roles("ADMIN")
                        .build();

        UserDetails bolek =
                User.withDefaultPasswordEncoder()
                        .username("bolek")
                        .password("ilolek")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(admin, bolek);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }
}
