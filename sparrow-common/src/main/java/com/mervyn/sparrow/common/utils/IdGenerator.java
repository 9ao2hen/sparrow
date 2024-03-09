package com.mervyn.sparrow.common.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @author 2hen9ao
 * @date 2024/3/7 12:05
 */
public class IdGenerator {

    private static int WORKER_ID = 1;
    private static int DATACENTER_ID = 1;

    public static Long genId(){
        return IdUtil.getSnowflake(WORKER_ID,DATACENTER_ID).nextId();
    }

    public static String genIdStr(){
        return IdUtil.getSnowflake(WORKER_ID,DATACENTER_ID).nextIdStr();
    }

}
