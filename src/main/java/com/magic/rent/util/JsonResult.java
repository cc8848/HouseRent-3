package com.magic.rent.util;

/**
 * Created by wuxinzhe on 16/9/20.
 */
public class JsonResult {

    private Boolean status = true;
    private String message;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public JsonResult setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }

    public static JsonResult success() {
        return new JsonResult().setStatus(true);
    }

    public static JsonResult success(Object data) {
        return success().setData(data);
    }

    public static JsonResult error() {
        return new JsonResult().setStatus(false);
    }

    public static JsonResult error(String message) {
        return error().setMessage(message);
    }

}
