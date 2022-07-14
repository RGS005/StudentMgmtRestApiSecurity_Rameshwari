//package my.smvc.hib.api.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import my.smvc.hib.api.service.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		// Security role
//		http
//		.httpBasic()
//		.and()
//		.authorizeRequests()
//		.antMatchers("/secure/**").hasRole("ADMIN")
//		.antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
//		.and()
////		.antMatchers("/").permitAll().and().formLogin();
//
//		.csrf().disable()
//		.formLogin().disable();
//		http.headers().frameOptions().disable();
//
//		// Not working
////		http.csrf().disable();
////
////		http.authorizeRequests().antMatchers("/api/**").authenticated().anyRequest().permitAll().and()
////				.authorizeRequests().antMatchers("/secure/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
////				.formLogin().permitAll();
//
//	}
//
////	@Bean
////	public BCryptPasswordEncoder encodePWD() {
////		return new BCryptPasswordEncoder();
////	}
////	
//
//	@Bean
//	public PasswordEncoder encodePWD() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//}
