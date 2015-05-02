package relaxtime.api.security;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import relaxtime.lib.model.api.Token;
import relaxtime.lib.service.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public TokenAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
//        this.authenticationManager = authenticationManager;
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
//        setAuthenticationManager(new NoOpAuthenticationManager());
//        setAuthenticationSuccessHandler(new TokenSimpleUrlAuthenticationSuccessHandler());
    }

    public final String TOKEN_PARAM_NAME = "token";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String token = request.getParameter(TOKEN_PARAM_NAME);
        Authentication userAuthenticationToken = checkToken(token);
        if (userAuthenticationToken == null) {
            throw new AuthenticationServiceException("You are not authorized.");
        }
        return userAuthenticationToken;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    // This method makes some validation depend on your application logic
    private Authentication checkToken(String tokenString) {
        try {
            if (Strings.isNullOrEmpty(tokenString)) {
                return null;
            }
            Token token = tokenService.getToken(tokenString);
            if (token == null) {
                throw new AuthenticationServiceException("You are not authorized.");
            }
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                    token.getUser().getUsername(),
                    token.getUser().getPassword())
            );
        } catch (Exception e) {
            logger.warn(e);
            return null;
        }
    }
}