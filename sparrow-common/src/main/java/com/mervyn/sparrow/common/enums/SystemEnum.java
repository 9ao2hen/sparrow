package com.mervyn.sparrow.common.enums;

/**
 * @author 2hen9ao
 * @date 2024/3/7 12:15
 */
public interface SystemEnum {

    enum Deleted {
        UNDELETED(false, "未删除"),
        DELETED(true, "已删除");

        final boolean code;
        final String desc;

        Deleted(boolean code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public boolean getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    enum CommonStatus {
        enable("1", "正常"),
        disable("2", "禁用");

        final String code;
        final String desc;

        CommonStatus(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }


    /**
     * 状态 ‘1’：正常 ‘2’：禁用
     */
    enum MenuStatus {
        enable(1, "正常"),
        disable(2, "禁用");

        final int code;
        final String desc;

        MenuStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
