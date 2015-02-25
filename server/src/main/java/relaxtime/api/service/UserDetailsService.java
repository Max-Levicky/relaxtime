
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import relaxtime.api.service.UserService;
import relaxtime.lib.model.User;

/**
 * @author maxim.levicky
 *         Date: 3/18/13
 *         Time: 10:54 AM
 */
@Service
public class UserDetailsService extends UserService
        implements org.springframework.security.core.userdetails.UserDetailsService, AuthenticationManager {

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return user;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        if (null == getByName(username)) {
            throw new AuthenticationCredentialsNotFoundException("User " + username + " not found");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }

}