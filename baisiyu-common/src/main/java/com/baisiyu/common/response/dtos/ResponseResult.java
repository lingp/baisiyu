package com.baisiyu.common.response.dtos;

import com.baisiyu.common.response.enums.AppHttpCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用的响应对象, 数据传输对象,用于展示层与服务层之间的数据传输对象
 *
 * @param <T>
 */
@Data
public class ResponseResult<T> implements Serializable {
    private String host;
    private Integer code;
    private String errMsg;
    private T data;

    public ResponseResult() {
        this.code = 200;
    }

    public static ResponseResult responseResult(int code, String errMsg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, errMsg);
    }

    public static ResponseResult okResult(int code, String errMsg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, errMsg);
    }

    public static ResponseResult okResult(Object data) {

        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getErrorMessage());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums) {
        return setAppHttpCodeEnum(enums, enums.getErrorMessage());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums, String errMsg) {
        return setAppHttpCodeEnum(enums, errMsg);
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums) {
        return okResult(enums.getCode(), enums.getErrorMessage());
    }

    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String errMsg) {
        return okResult(enums.getCode(), errMsg);
    }

    public ResponseResult<T> error(Integer code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
        return this; // ps 这里是this
    }

    public ResponseResult<T> ok(Integer code, T data, String errMsg) {
        this.code = code;
        this.data = data;
        this.errMsg = errMsg;
        return this; // ps 这里是this
    }

    public ResponseResult<T> ok(T data) {
        this.data = data;
        return this; // ps 这里是this
    }


}
