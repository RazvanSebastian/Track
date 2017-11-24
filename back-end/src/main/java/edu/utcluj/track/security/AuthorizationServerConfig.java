package edu.utcluj.track.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	public final static String RESOURCE_ID = "server-resource";
	
	@Value("${oauth.tokenExpire}")
	private int tokenExpire;
	
	@Value("${oauth.refreshExpire}")
	private int refreshExpire;

	@Value("${oauth.resources}")
	private String resources;

	@Value("${jwt.publicKey}")
	private String publicKey;

	@Value("${jwt.privateKey}")
	private String privateKey;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setVerifierKey(publicKey);
		converter.setSigningKey(privateKey);
		return converter;
	}
	
	@Bean
	public TokenEnhancer customTokenEnhancer() {
	    return new CustomTokenEnhancer();
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer client) throws Exception {
		client.inMemory()
			.withClient("client")
			.secret("clientsecret")
			.scopes("read", "write")
			.resourceIds(RESOURCE_ID)
			.authorizedGrantTypes("password", "refresh_token", "authorization_code")
			.authorities("ROLE_TRUSTED_CLIENT")
			.accessTokenValiditySeconds(tokenExpire) // one day available
			.refreshTokenValiditySeconds(refreshExpire);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer server) throws Exception {
		server
			.tokenKeyAccess("hasAuthority('ROLE_TRUSTED_CLIENT')")
			.checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')"); 
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(customTokenEnhancer(), accessTokenConverter()));
		endpoints
			.tokenStore(tokenStore())
			.tokenEnhancer(enhancerChain)
			.authenticationManager(authenticationManager)
			.accessTokenConverter(accessTokenConverter());
	}

}