package relaxtime.lib.model.api.response;

/**
 * @author Max Levicky
 */
public class Response extends IApiResponse implements ApiResponse {
    public Response() {
    }

    public Response(ResultCode resultCode) {
        super(resultCode);
    }

    public Response(ResultCode resultCode, String message) {

        super(resultCode, message);
    }

    public Response(String message) {
        super(message);
    }
}
