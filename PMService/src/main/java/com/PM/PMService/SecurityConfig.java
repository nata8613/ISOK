package com.PM.PMService;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter{

	/*@Autowired
    public void configureGlobal(
      AuthenticationManagerBuilder auth) throws Exception {
  
        KeycloakAuthenticationProvider keycloakAuthenticationProvider
         = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(
          new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }
	
	@Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    // Specifies the session authentication strategy
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    
    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public AccessToken accessToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return ((KeycloakSecurityContext) ((KeycloakAuthenticationToken) request.getUserPrincipal()).getCredentials()).getToken();
    }
    
    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public KeycloakSecurityContext getKeycloakSecurityContext() {
        return ((KeycloakPrincipal) getRequest().getUserPrincipal()).getKeycloakSecurityContext();
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }*/
	
	@Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	      KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
	      keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
	      auth.authenticationProvider(keycloakAuthenticationProvider);
	   }
	   @Bean
	   public org.keycloak.adapters.KeycloakConfigResolver KeycloakConfigResolver() {
	      return new KeycloakSpringBootConfigResolver();
	   }
	   @Bean
	   @Override
	   protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
	      return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	   }

	   @Override
	   protected void configure(HttpSecurity http) throws Exception
	   {
	      super.configure(http);
	      http
	            .authorizeRequests().antMatchers("/**").authenticated().anyRequest().permitAll().and().csrf().disable();
	            /*.httpBasic().and()
	            .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
	            .csrf().csrfTokenRepository(csrfTokenRepository());*/
	   }
	   
	   private CsrfTokenRepository csrfTokenRepository() {
		   HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		   repository.setHeaderName("X-XSRF-TOKEN");
		   return repository;
		 }
}
