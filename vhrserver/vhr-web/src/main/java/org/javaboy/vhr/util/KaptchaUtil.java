package org.javaboy.vhr.util;

import org.javaboy.vhr.constant.FontEnum;
import org.javaboy.vhr.constant.YesNoEnum;

import java.util.Properties;

/**
 * @author zhangqi
 * @date 2020/7/13
 */
public class KaptchaUtil {
    private static final YesNoEnum  DEFAULT_BORDER = YesNoEnum.YES;
    private static final String DEFAULT_COLOR = "blue";
    private static final int DEFAULT_LENGTH = 4;
    private static final FontEnum DEFAULT_FONT_NAME = FontEnum.ARIAL;

    public static void setStyle(Properties properties) {
        setBorder(properties);
        setColor(properties);
        setLength(properties);
        setFontName(properties);
    }

    public static void setBorder(Properties properties) {
        properties.setProperty("kaptcha.border", DEFAULT_BORDER.getValue());
    }

    public static void setBorder(Properties properties, YesNoEnum yesNoEnum) {
        properties.setProperty("kaptcha.border", yesNoEnum.getValue());
    }

    public static void setColor(Properties properties) {
        properties.setProperty("kaptcha.border.color", DEFAULT_COLOR);
    }

    public static void setColor(Properties properties, String color) {
        properties.setProperty("kaptcha.border.color", color);
    }

    public static void setLength(Properties properties) {
        properties.setProperty("kaptcha.textproducer.char.length", String.valueOf(DEFAULT_LENGTH));
    }

    public static void setLength(Properties properties, int length) {
        properties.setProperty("kaptcha.textproducer.char.length", String.valueOf(length));
    }

    public static void setFontName(Properties properties) {
        properties.setProperty("kaptcha.textproducer.font.names", DEFAULT_FONT_NAME.getFontName());
    }

    public static void setFontName(Properties properties, FontEnum fontEnum) {
        properties.setProperty("kaptcha.textproducer.font.names", fontEnum.getFontName());
    }
}
