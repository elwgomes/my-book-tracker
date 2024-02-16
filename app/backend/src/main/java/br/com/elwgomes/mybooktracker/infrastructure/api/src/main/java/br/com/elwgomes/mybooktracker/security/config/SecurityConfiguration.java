package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.config;

import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String H2_CONSOLE_PATH = "/h2-console/**";

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher(H2_CONSOLE_PATH));
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                /*
                here we define the way we will handle authentications
                it can be STATEFUL (keeps information stored on the server)
                or STATELESS (does not keep)
                we're going to use stateless
                 */
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "api/v1/auth/login").permitAll() // full access to evbody
                                .requestMatchers(HttpMethod.POST, "api/v1/user/create").permitAll() // full access to evbody
                                .requestMatchers(toH2Console()).permitAll() // permit h2
                                .anyRequest().authenticated() // all paths need auth
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
