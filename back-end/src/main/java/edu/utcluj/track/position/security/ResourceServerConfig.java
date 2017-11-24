package edu.utcluj.track.position.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${jwt.publicKey}")
	private String publicKey;

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	@Primary
	public ResourceServerTokenServices resourceServerTokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(this.tokenStore());
		return tokenServices;
	}

	@Bean
	protected JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
			.tokenStore(tokenStore())
			.resourceId(AuthorizationServerConfig.RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.requestMatcher(new OAuthRequestedMatcher()).authorizeRequests().antMatchers("/position/**").authenticated();
	}

}