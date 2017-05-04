package com.qwp.project.controller;

import com.qwp.core.po.springjdbc.GenericDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by project on 2017/4/21.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println(e.toString());
            return "";
        }
        model.addAttribute("user", userName);
        return "redirect:/401.html";
    }
}
