package com.yinsw.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yinsw.common.security.annotation.EnableCustomConfig;
import com.yinsw.common.security.annotation.EnableYinswFeignClients;
import com.yinsw.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author yinsw
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableYinswFeignClients
@SpringBootApplication
public class YinswGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(YinswGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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
