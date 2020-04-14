package org.iesalixar.dfernandezs.proyecto.security;

import org.iesalixar.dfernandezs.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	String[] resources = new String[] {
			"/css/**", "/images/**", "/js/**"
	};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
            	.authorizeRequests()
            	.antMatchers(resources).permitAll()
            	.antMatchers("/", "/index", "/register", "/login").permitAll()
//            	.antMatchers("/private/**").hasAnyRole( "ADMIN", "USER")
            	.anyRequest().authenticated()
            		.and()
            	.formLogin()
            		.loginPage("/login")
            		.permitAll()
            		.defaultSuccessUrl("/private/eventCreator")
            		.failureUrl("/login?error=true")
            		.usernameParameter("userLogin")
            		.passwordParameter("passLogin")
            		.and()
            	.logout()
            		.permitAll()
            		.logoutSuccessUrl("/login?logout");
    }
    
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserService userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}
