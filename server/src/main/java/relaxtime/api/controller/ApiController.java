package relaxtime.api.controller;

import relaxtime.api.model.ApiResponse;
import relaxtime.api.model.ApiResponseStatus;
import relaxtime.api.model.ApiResponseStatus.ApiStatusCode;

import java.util.Objects;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
abstract public class ApiController {

    protected <T> ApiResponse<T> createOkResponse() {
        return new ApiResponse<>(ApiResponseStatus.getOkStatus());
    }

    protected <T> ApiResponse<T> wrapResponse(T data) {
        return new ApiResponse<>(ApiResponseStatus.getOkStatus(), data);
    }

    protected <T> ApiResponse<T> wrapResponse(ApiStatusCode code, String message) {
        return new ApiResponse<>(new ApiResponseStatus(code, message));
    }

    protected <T> ApiResponse<T> wrapResponse(ApiStatusCode code, String message, T data) {
        return new ApiResponse<>(new ApiResponseStatus(code, message), data);
    }
}
