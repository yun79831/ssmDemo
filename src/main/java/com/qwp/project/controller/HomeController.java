package com.qwp.project.controller;

import com.qwp.core.po.springjdbc.GenericDao;
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

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model)throws Exception {
        int userId = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("user", userId);
        return "welcome";
    }
}
