package relaxtime.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relaxtime.lib.model.User;
import relaxtime.lib.model.api.Token;
import relaxtime.lib.utils.SecurityUtils;

/**
 * @author Max Levicky
 */
@Service
public class TokenService {
//    @Autowired
//    private

    public Token getNewToken(User user) {
        return new Token(SecurityUtils.nextSessionId(), user);
    }

    public User getUserByToken() {
        return null;
    }
}
