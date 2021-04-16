package indi.zhifa.learn.common.base;

import lombok.Getter;

/**
 * @author 芝法酱
 */
public class ServiceException extends Exception {
    public ServiceException() {
        this(0, "");
    }

    public ServiceException(String message) {
        this(0, message);
    }

    public ServiceException(int pCode, String message) {
        super(message);
    }

    @Getter
    private int code;

}
