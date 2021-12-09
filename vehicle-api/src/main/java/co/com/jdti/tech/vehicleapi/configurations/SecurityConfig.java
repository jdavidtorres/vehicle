package co.com.jdti.tech.vehicleapi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.com.jdti.tech.vehicleapi.services.UserServicesImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserServicesImpl userServicesImpl;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilter(new AuthenticationFilter(authenticationManager()))
                .addFilter(new AuthorizationFilter(authenticationManager())).csrf().disable().cors().disable()
                .authorizeRequests().antMatchers("/user/**", "/login").permitAll().anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userServicesImpl).passwordEncoder(passwordEncoder);
    }
}
