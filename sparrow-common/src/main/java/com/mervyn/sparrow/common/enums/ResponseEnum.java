package com.mervyn.sparrow.common.enums;

/**
 * @author 2hen9ao
 * @date 2024/3/5 13:55
 */
public interface ResponseEnum {


    enum ResultCode {
        success("0", "成功"),
        error("1", "失败");
        final String code;
        final String msg;

        ResultCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }


}
