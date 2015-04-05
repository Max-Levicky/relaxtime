package relaxtime.lib.model.api.response;

import relaxtime.lib.model.api.Token;

/**
 * @author Max Levicky
 */
public class FailedAuthResponse extends IApiResponse implements AuthResponse {
    public FailedAuthResponse(String message) {
        super(ResultCode.ERROR, message);
    }
}
