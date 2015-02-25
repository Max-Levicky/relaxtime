package relaxtime.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import relaxtime.api.dao.UserRepository;
import relaxtime.lib.model.User;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Service
public class UserService extends BaseService implements org.springframework.security.core.userdetails.UserDetailsService, AuthenticationManager {
    @Autowired
    private UserRepository userRepository;
    public User getByName(String userName) {
        return userRepository.getCurrentUser(userName);
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        } else {
            return new User();
        }
    }

    public boolean isAuthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }

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
