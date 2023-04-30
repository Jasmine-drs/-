package com.lsu.lkrf.exception;

/**
 * @author Jasmine-drs
 * @date 2022/11/6 20:27
 */
public class SystemException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }



    public SystemException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
