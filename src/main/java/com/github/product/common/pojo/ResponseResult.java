package com.github.product.common.pojo;

import lombok.Data;

/**
 * 通用响应结果对象
 * 
 * @param <T> 响应数据类型
 */
@Data
public class ResponseResult<T> {
    
    /**
     * 响应码，200=成功
     */
    private int code;
    
    /**
     * 响应信息
     */
    private String msg;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 成功响应
     * 
     * @param data 响应数据
     * @param <T> 响应数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    
    /**
     * 成功响应（无数据）
     * 
     * @param <T> 响应数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> success() {
        return success(null);
    }
    
    /**
     * 错误响应
     * 
     * @param code 错误码
     * @param msg 错误信息
     * @param <T> 响应数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> error(int code, String msg) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    /**
     * 错误响应（带数据）
     * 
     * @param code 错误码
     * @param msg 错误信息
     * @param data 响应数据
     * @param <T> 响应数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> error(int code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}