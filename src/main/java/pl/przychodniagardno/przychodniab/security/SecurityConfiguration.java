package pl.przychodniagardno.przychodniab.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static pl.przychodniagardno.przychodniab.security.Roles.ADMIN;
import static pl.przychodniagardno.przychodniab.security.Roles.MODERATOR;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/news/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole(MODERATOR.name(), ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails admin = User.builder()
                .username("mario")
                .password(passwordEncoder.encode("maslo"))
                .roles(ADMIN.name())
                .build();

         UserDetails redaktor = User.builder()
                .username("redaktor")
                .password(passwordEncoder.encode("1234"))
                 .roles(MODERATOR.name())
                .build();

        return new InMemoryUserDetailsManager(
                admin, redaktor
        );
    }
}
