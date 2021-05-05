package com.itheima.springbootuse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password, Model model,HttpSession session){

        if (!StringUtils.isEmpty(username)&&"12345".equals(password)){
           session.setAttribute("loginUser",username);
           //成功,为了防止表单重复提交。
          return "dashboard.html";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";

        }
    }

}
