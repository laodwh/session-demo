package com.laod.sessiondemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @package: com.laod.sessiondemo
 * @description: ---
 * @author: laod
 * @email dailong@sumaott.com
 * @date: 2019/12/25 20:02
 **/
@RestController
public class DemoController {


    /**
     * 集中常见会话
     *
     *粘性会话 Sticky Session 来自一个用户的会话，尽可能落到一台机器上 机器挂了，用户体验差
     *
     *会话复制 Session Replication 每台机器都存会话，浪费资源
     *
     *集中会话 Centralized Session 简化用户管理，无需绑定特定容器 类似redis，mongodb，jdbc
     *
     */
    @RequestMapping(value = "/hello")
    public String DemoSession(HttpSession session, @RequestParam String name){

        if(session.getAttribute(name) ==null){
            session.setAttribute(name,name);
        }
        return "hello "+name;
    }

}
