package com.lsu.lkrf.tool;

import lombok.Data;

/**
 * 统一返回结果
 * @author Jasmine-drs
 * @date 2022/11/3 18:27
 */
@Data
public class R<T> {
    private String message;
    private int code;
    private T data;

    public static <T> R<T> success(T object) {
        R<T> tr = new R<>();
        tr.code = 1;
        tr.data = object;
        return tr;
    }

    public static <T> R<T> err(String message) {
        R<T> tr = new R<>();
        tr.code = 0;
        tr.message = message;
        return tr;
    }
}
