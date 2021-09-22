package demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDatasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDatasource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/register/**").permitAll().antMatchers("/").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/css/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/signin")
				.loginProcessingUrl("/authenticateuser").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/access_denied");
	}

}
