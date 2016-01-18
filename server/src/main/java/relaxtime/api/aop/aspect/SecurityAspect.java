package relaxtime.api.aop.aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import relaxtime.lib.model.User;

/**
 * @author Max Levicky
 * @date 08.01.2016.
 */
public class SecurityAspect extends BaseAspect {
    @Before("userArg() && controller()")
    public void insertUser(User user) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            throw new SecurityException("You have to be authorized to use this method.");
        }
    }
}
