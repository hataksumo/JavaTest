package indi.zhifa.learn.common.response;

import indi.zhifa.learn.common.response.enums.HttpStatus;
import lombok.Data;

/**
 * R Created by IntelliJ IDEA.
 *
 * @Author: 芝法酱
 * @Create 2021/3/17 10:33
 */
@Data
public class RestResponse<T> {
    private T data;
    private int code;
    private int errorCode;
    private String errMsg;
    public RestResponse(){
        code = HttpStatus.OK.value();
    }

    public RestResponse(T pData){
        code = HttpStatus.OK.value();
        data = pData;
    }

    public RestResponse(int pCode, int pErrCode, String pErrMsg){
        code = pCode;
        errorCode = pErrCode;
        errMsg = pErrMsg;
    }

    public static RestResponse ok(){
        RestResponse r = new RestResponse();
        return r;
    }

    public static <T>RestResponse ok(T pData){
        RestResponse r = new RestResponse(pData);
        return r;
    }

    public static RestResponse clientError(int pErrCode, String pErrMsg){
        RestResponse r = new RestResponse(HttpStatus.BAD_REQUEST.value(),pErrCode,pErrMsg);
        return r;
    }

    public static RestResponse serverError(int pErrCode, String pErrMsg){
        RestResponse r = new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),pErrCode,pErrMsg);
        return r;
    }

    public static RestResponse notImplement(){
        RestResponse r = new RestResponse(HttpStatus.NOT_IMPLEMENTED.value(),
                0,
                "该接口没有实现");
        return r;
    }

    public static RestResponse unAuthorise(int pErrCode, String pErrMsg){
        RestResponse r = new RestResponse(HttpStatus.UNAUTHORIZED.value(),
                pErrCode,
                pErrMsg);
        return r;
    }

}
