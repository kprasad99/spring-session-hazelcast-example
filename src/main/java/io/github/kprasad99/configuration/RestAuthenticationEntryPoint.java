package io.github.kprasad99.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		//Authentication failed, send error response.
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// comment www-authenticate as triggers browser to prompt for username/password
		// response.addHeader("WWW-Authenticate", "Basic realm="+getRealmName());
		response.getWriter().println("HTT{ Status 401 : " + authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() {
		setRealmName("Realm");
		super.afterPropertiesSet();
	}
	
}

