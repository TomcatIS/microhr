package org.javaboy.vhr.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.javaboy.vhr.config.VerificationCode;
import org.javaboy.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author zhangqi
 */
@RestController
public class LoginController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        // 设置响应的验证码不缓存
        resp.setHeader("Cache-Control", "no-cache, no-store");
        resp.setContentType("image/jpg");
        // 生成验证码文本
        String text = defaultKaptcha.createText();
        request.getSession().setAttribute("verify_code", text);
        // 生成验证码图片
        BufferedImage image = defaultKaptcha.createImage(text);
        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            throw new RuntimeException("验证码无法生成！");
        }
        /*VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());*/
    }
}
