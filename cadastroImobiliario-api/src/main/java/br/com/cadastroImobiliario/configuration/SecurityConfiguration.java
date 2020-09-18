package br.com.cadastroImobiliario.configuration;

import br.com.cadastroImobiliario.security.jwt.JWTConfigurer;
import br.com.cadastroImobiliario.security.DetalhesUsuarioService;
import br.com.cadastroImobiliario.security.jwt.TokenProvider;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final DetalhesUsuarioService detalhesUsuarioService;
    private final TokenProvider tokenProvider;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
                                 DetalhesUsuarioService detalhesUsuarioService,
                                 TokenProvider tokenProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.detalhesUsuarioService = detalhesUsuarioService;
        this.tokenProvider = tokenProvider;
    }

    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                    .userDetailsService(detalhesUsuarioService)
                    .passwordEncoder(passwordEncoder());
        } catch (Exception ex) {
            throw new BeanInitializationException("A configuração de segurança falhou.", ex);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/autenticar").permitAll()
                .antMatchers(HttpMethod.POST, "/api/usuario/salvar").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(securityConfigurerAdapter());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }
}
