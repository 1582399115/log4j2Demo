package com.xinlei.log4j2demo2.common;

import lombok.Data;

@Data
public class Result<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体信息
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.data = data;
    }
    public static Result getSuccess(){
        return new Result(200,"成功");
    }
    public static Result getFail(){
        return new Result(400,"失败");
    }
}
