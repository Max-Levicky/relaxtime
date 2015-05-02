package relaxtime.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relaxtime.lib.dao.TokenRepository;
import relaxtime.lib.model.User;
import relaxtime.lib.model.api.Token;
import relaxtime.lib.utils.SecurityUtils;

/**
 * @author Max Levicky
 */
@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public Token getNewToken(User user) {
        String newToken;
        do {
            newToken = SecurityUtils.nextSessionId();
        } while (tokenRepository.tokenExists(newToken));
        Token token = new Token(newToken, user);
        tokenRepository.save(token);
        return token;
    }

    public boolean checkToken(String token) {
        return tokenRepository.tokenExists(token);
    }

    public Token getToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public User getUserByToken(String token) {
        Token savedToken = getToken(token);
        return savedToken == null ? null : savedToken.getUser();
    }
}
