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
        unknown("0", "未知"),
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


        public static String getDesc(String code) {
            for (CommonStatus status : CommonStatus.values()) {
                if (status.getCode().equals(code)) {
                    return status.getDesc();
                }
            }
            return unknown.getDesc();
        }
    }

    //菜单类型 1:目录,2:菜单，3：按钮
    enum MenuType {
        unknown("0", "未知"),
        catalog("1", "目录"),
        menu("2", "菜单"),
        button("3", "按钮");

        final String code;
        final String desc;

        MenuType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static String getDesc(String code) {
            for (MenuType menuType : MenuType.values()) {
                if (menuType.getCode().equals(code)) {
                    return menuType.getDesc();
                }
            }
            return unknown.getDesc();
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

    /**
     * 性别
     */
    enum GENDER {
        unknown(0, "未知"),
        male(1, "男"),
        female(2, "女");

        final int code;
        final String desc;

        GENDER(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static String getDesc(int code) {
            for (GENDER gender : GENDER.values()) {
                if (gender.getCode() == code) {
                    return gender.getDesc();
                }
            }
            return unknown.getDesc();
        }

    }
}
