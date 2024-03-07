package com.mervyn.sparrow.config.lang;

import cn.hutool.core.util.StrUtil;
import com.mervyn.sparrow.config.expection.SparrowException;

import java.util.function.Supplier;

/**
 * @author 2hen9ao
 * @date 2024/3/7 14:58
 */
public class AssertSpr {

    public static <T extends CharSequence> T notBlank(T text,String errorMsgTemplate,Object... params)throws SparrowException{
        return notBlank(text, () -> new SparrowException("400400", StrUtil.format(errorMsgTemplate, params)));
    }

    public static <T extends CharSequence, X extends Throwable> T notBlank(T text, Supplier<X> errorMsgSupplier) throws X {
        if (StrUtil.isBlank(text)) {
            throw errorMsgSupplier.get();
        }
        return text;
    }


    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> supplier) throws X {
        if (false == expression) {
            throw supplier.get();
        }
    }

    /**
     * Assert.isTrue(i > 0, "The value must be greater than zero");
     * @param expression
     * @param errorMsgTemplate
     * @param params
     */
    public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws SparrowException {
        isTrue(expression, () -> new SparrowException("400400",StrUtil.format(errorMsgTemplate, params)));
    }


}
