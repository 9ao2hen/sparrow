package com.mervyn.sparrow.config.util;

import com.mervyn.sparrow.config.expection.SparrowException;

/**
 * @author 2hen9ao
 * @date 2024/4/10 21:34
 */
public class Exps {

    public static void fail(String message) {
        throw new SparrowException(message);
    }

    public static void fail(String code,String message) {
        throw new SparrowException(code,message);
    }
}
