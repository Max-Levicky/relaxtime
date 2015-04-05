package relaxtime.lib.model.api.response;

import relaxtime.lib.model.api.Token;

/**
 * @author Max Levicky
 */
public class SuccessAuthResponse implements AuthResponse {
    private Token token;

    public SuccessAuthResponse(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
