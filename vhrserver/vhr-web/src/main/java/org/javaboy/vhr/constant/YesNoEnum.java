package org.javaboy.vhr.constant;

/**
 * @author zhangqi
 * @date 2020/7/13
 */
public enum YesNoEnum {
    /**
     *
     */
    YES("yes"),
    NO("no");
    private String value;
    YesNoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
