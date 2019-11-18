/**
 * @author CJ Cucio
 * @date 18 November 2019
 */

package yib00005xs.std511.library.model;

public class Response<T> {
    
    private Integer code;
    
    private String message;
    
    private T data;

    public Response() {
        this.code = null;
        this.message = null;
        this.data = null;
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
    
    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" + "code=" + code + ", message=" + message + ", data=" + data + '}';
    }
    
}
