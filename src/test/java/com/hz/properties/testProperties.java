package com.hz.properties;


import com.hz.properties.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *  可以在测试期间类似编码自动注入
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testProperties {

    @Resource
    private Person person;

    @Resource
    private ApplicationContext ioc;

    @Test
    public void testHelloService(){
        Boolean b = ioc.containsBean("helloService");
        System.out.println(b);


    }

    @Test
    public void testProperties(){
        System.out.println(person);
    }
}
