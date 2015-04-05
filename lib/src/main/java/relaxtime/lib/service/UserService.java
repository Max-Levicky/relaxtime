package relaxtime.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import relaxtime.lib.dao.UserRepository;
import relaxtime.lib.model.User;

import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Service
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;
    public User getByName(String userName) {
        return userRepository.getUserByName(userName);
    }

    public boolean checkAuth(String login, String password) {
        return getByName(login) != null;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new User();
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        } else {
            return new User();
        }
    }

    public List<User> getMostUnrelaxed() {
        return userRepository.getMostUnrelaxed();
    }
}
