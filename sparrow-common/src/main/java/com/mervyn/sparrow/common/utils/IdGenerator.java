package com.mervyn.sparrow.common.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @author 2hen9ao
 * @date 2024/3/7 12:05
 */
public class IdGenerator {

    public static Long genId(){
        return IdUtil.getSnowflake(1,1).nextId();
    }

}
