package com.shop.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {


    @Bean
    public DefaultKaptcha buildKaptcha() {

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes"); // 是否有边框
        properties.setProperty("kaptcha.border.color", "105,179,90");// 边框颜色
        properties.setProperty("kaptcha.textproducer.font.color", "green"); // 字体颜色
        properties.setProperty("kaptcha.session.key", "code"); // session key -验证码
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑"); // 验证的字体
        properties.setProperty("kaptcha.border.thickness", "1"); // 边框粗细度 默认为1
        properties.setProperty("kaptcha.producer.impl", "DefaultTextCreator"); // 验证码生成器 默认为DefaultKaptcha
        properties.setProperty("kaptcha.textproducer.char.string", ""); // 验证码文本字符内容范围 默认为abcde2345678gfynmnpwx
        properties.setProperty("kaptcha.textproducer.char.length", "4"); // 验证码文本字符长度 默认为5
        properties.setProperty("kaptcha.textproducer.font.size", "50"); // 验证码文本字符大小 默认为40
        properties.setProperty("kaptcha.textproducer.char.space", "6"); // 验证码文本字符间距 默认为2
        properties.setProperty("kaptcha.image.width", "200"); // 验证码图片宽度 默认为200
        properties.setProperty("kaptcha.image.height", "60"); // 验证码图片高度 默认为40

        Config config = new Config(properties);
        kaptcha.setConfig(config);

        return kaptcha;
    }


}
