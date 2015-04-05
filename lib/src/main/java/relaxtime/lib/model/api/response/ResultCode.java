package relaxtime.lib.model.api.response;

/**
 * @author Max Levicky
 */
public enum  ResultCode {
    SUCCESS(200, "OK"), BAD_REQUEST(400, "Bad Request"), ERROR(500, "Internal Server Error");

    ResultCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
