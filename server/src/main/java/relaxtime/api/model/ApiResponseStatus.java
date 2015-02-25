package relaxtime.api.model;

import java.net.HttpURLConnection;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ApiResponseStatus {
    private int code;
    private String message;

    public static enum ApiStatusCode {
        // General codes
        OK(HttpURLConnection.HTTP_OK),
        PRECONDITION(HttpURLConnection.HTTP_PRECON_FAILED),
        FORBIDDEN(HttpURLConnection.HTTP_FORBIDDEN),
        ERROR(HttpURLConnection.HTTP_INTERNAL_ERROR);
        private int code;

        ApiStatusCode(int code) {
            this.code = code;
        }

        public int getCode() {

            return code;
        }
    }

    public static ApiResponseStatus getOkStatus() {
        return new ApiResponseStatus(ApiStatusCode.OK.getCode());
    }

    public static ApiResponseStatus getErrorStatus() {
        return new ApiResponseStatus(ApiStatusCode.ERROR.getCode());
    }

    public ApiResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponseStatus(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
