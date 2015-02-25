package relaxtime.api.model;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ApiResponse<T> {
    private ApiResponseStatus status;
    private T data;

    public ApiResponse(ApiResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(ApiResponseStatus status) {

        this.status = status;
    }

    public ApiResponse() {

    }

    public ApiResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ApiResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
