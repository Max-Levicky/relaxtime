package relaxtime.api.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus;

import java.util.Objects;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
abstract public class ApiController {

    protected ApiResponse createOkResponse() {
        return new ApiResponse(ApiResponseStatus.getOkStatus());
    }

    protected <T> ApiResponse<T> wrapResponse(T data) {
        return new ApiResponse<T>(ApiResponseStatus.getOkStatus(), data);
    }

    protected <T> ApiResponse<T> wrapResponse(int code, String message, T data) {
        return new ApiResponse<T>(new ApiResponseStatus(code, message), data);
    }
}
