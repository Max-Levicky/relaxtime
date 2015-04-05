package relaxtime.lib.model.api.response;

/**
 * @author Max Levicky
 */
public abstract class IApiResponse {
    private ResultCode resultCode;
    private String message;

    public IApiResponse() {
        resultCode = ResultCode.SUCCESS;
    }

    public IApiResponse(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public IApiResponse(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public IApiResponse(String message) {
        this.resultCode = ResultCode.SUCCESS;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
