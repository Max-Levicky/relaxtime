package relaxtime.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import relaxtime.lib.model.User;
import relaxtime.lib.service.UserService;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Service
public class AuthService implements UserDetailsService, AuthenticationManager {
    @Autowired
    private UserService userService;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return user;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        if (null == userService.getByName(username)) {
            throw new AuthenticationCredentialsNotFoundException("User " + username + " not found");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }

    public boolean isAuthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }
}
