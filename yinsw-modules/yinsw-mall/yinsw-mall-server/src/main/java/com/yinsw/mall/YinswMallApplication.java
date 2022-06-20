package com.yinsw.mall;

import com.yinsw.common.security.annotation.EnableCustomConfig;
import com.yinsw.common.security.annotation.EnableYinswFeignClients;
import com.yinsw.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author printguy
 * @version 1.0.0
 * @className YinswMallApplication.java
 * @description TODO
 * @createTime 2022年06月19日 14:34:00
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableYinswFeignClients
@SpringBootApplication
public class YinswMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(YinswMallApplication.class);
        System.out.println("(♥◠‿◠)ﾉﾞ  商品模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
