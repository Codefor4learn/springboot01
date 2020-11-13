package com.hz.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
public class thymeleafController {

    @RequestMapping("thymeleaf")
    public String testThymeleaf(Map<String,Object> map){

        map.put("hello","<p1>你好</p1>");
        map.put("users", Arrays.asList("zs","lisi","hz"));

        return "thymeleaf";
    }

}
