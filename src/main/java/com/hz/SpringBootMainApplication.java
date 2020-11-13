package com.hz;

import com.hz.helloworld.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;

//@ImportResource(locations = {"classpath:spring.xml"}) //导入spring配置文件，让其生效
@SpringBootApplication // 使用注解来标注一个主程序类，说明这是springboot应用
public class SpringBootMainApplication {

    public static void main(String[] args) {
        Annotation[] obj = HelloController.class.getAnnotations();
        if(obj.length == 0){
            System.out.println("=================================================null");
        }
        for (Annotation o : obj){
            System.out.println("================================================="+o);
        }

        SpringApplication.run(SpringBootMainApplication.class,args);

    }
}
