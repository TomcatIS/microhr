package org.javaboy.vhr.constant;

/**
 * @author zhangqi
 * @date 2020/7/13
 */
public enum FontEnum {
    /**
     *
     */
    ARIAL("arial"),
    COURIER("courier");
    private String fontName;
    FontEnum(String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }
}
