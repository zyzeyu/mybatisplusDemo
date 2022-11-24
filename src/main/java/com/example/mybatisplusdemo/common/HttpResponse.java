package com.example.mybatisplusdemo.common;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * TODO
 *
 * @author qinzh
 * @version 1.0
 * @date 2022/11/24 17:43
 */
@Data
public class HttpResponse<T> {
    private static final long serialVersionUID = 1L;

    private static final int SUCC = 200;

    private static final int FAIL = 500;

    private static final int FAIL_LOGIN = 302;

    private int code;
    private String msg;
    private T data;

    public HttpResponse(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public HttpResponse() {
    }
    public static <T> HttpResponse<T> success() {
        return new HttpResponse<T>(SUCC, "success", null);
    }
    public static <T> HttpResponse<T> success(String message) {
        return new HttpResponse<T>(SUCC, message, null);
    }
    public static <T> HttpResponse<T> success(T data) {
        return new HttpResponse<T>(SUCC, "success", data);
    }
    public static <T> HttpResponse<T> success(String message, T data) {
        return new HttpResponse<T>(SUCC, message, data);
    }

    public static <T> HttpResponse<T> error() {
        return new HttpResponse<T>(FAIL, "fail", null);
    }
    public static <T> HttpResponse<T> error(String message) {
        return new HttpResponse<T>(FAIL, message, null);
    }
    public static <T> HttpResponse<T> error(T data) {
        return new HttpResponse<T>(FAIL, "fail", data);
    }
    public static <T> HttpResponse<T> error(String message, T data) {
        return new HttpResponse<T>(FAIL, message, data);
    }
    public static <T> HttpResponse<T> error(int code,String message, T data) {
        return new HttpResponse<T>(code, message, data);
    }

    public static <T> HttpResponse<T> error(int code,String message) {
        return new HttpResponse<T>(code, message, null);
    }

    public static <T> HttpResponse<T> badrequest() {
        return new HttpResponse<T>(FAIL, "no identifier arguments", null);
    }
    public static <T> HttpResponse<T> badrequest(String message) {
        return new HttpResponse<T>(FAIL, message, null);
    }
    public static <T> HttpResponse<T> badrequest(T data) {
        return new HttpResponse<T>(FAIL, "no identifier arguments", data);
    }
    public static <T> HttpResponse<T> badrequest(String message, T data) {
        return new HttpResponse<T>(FAIL, message, data);
    }
    public static <T> HttpResponse<T> badrequest(int code,String message, T data) {
        return new HttpResponse<T>(code, message, data);
    }

    public static <T> HttpResponse<T> noLogin(String message) {
        return new HttpResponse<T>(FAIL_LOGIN, message, null);
    }

}
