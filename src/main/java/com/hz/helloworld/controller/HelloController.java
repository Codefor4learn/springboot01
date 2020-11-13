package com.hz.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController extends Object{

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping("thymeleaf1")
    public String testThymeleaf(HttpServletRequest request){

        request.setAttribute("name","hz");
        return "index";
    }
}
