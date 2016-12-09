package com.magic.rent.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe   创建时间: 16/9/20
 * 类说明:
 * 更新记录：
 */
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 8134245754393400511L;

    private boolean status = true;
    private String message;
    private Object data;
    private Object rows;
    private long total;
    private static Logger logger = LoggerFactory.getLogger(JsonResult.class);

    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public JsonResult setStatus(boolean status) {
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
        JsonResult jsonResult = success().setData(data);
        logger.info(jsonResult.toString());
        return jsonResult;
    }

    public static JsonResult success(String message, Object data) {
        JsonResult jsonResult = success().setData(data).setMessage(message);
        logger.info(jsonResult.toString());
        return jsonResult;
    }

    public static JsonResult error() {
        return new JsonResult().setStatus(false);
    }

    public static JsonResult error(String message) {
        JsonResult jsonResult = error().setMessage(message);
        logger.info(jsonResult.toString());
        return jsonResult;
    }

    public static JsonResult table(Object rows, long total) {
        JsonResult jsonResult = success().setRows(rows).setTotal(total);
        logger.info(jsonResult.toString());
        return jsonResult;
    }

    public Object getRows() {
        return rows;
    }

    public JsonResult setRows(Object rows) {
        this.rows = rows;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public JsonResult setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
