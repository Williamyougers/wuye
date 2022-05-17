package com.fc.controller;
import com.fc.service.AdminService;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public String login(String username, String password, @RequestParam String usertype, HttpSession session) {
        ResultVo vo;
        System.err.println(username);
        if (usertype.equals("user")) {
            vo = userService.login(username, password);
        } else {
            vo = adminService.login(username, password);
        }


        if (vo.getSuccess()) {
            //  如果是200说明是用户登录成功
            if (vo.getCode().equals(300)) {
                session.setAttribute("customAccount", vo.getData());

                return "forward:/index2.jsp";
            } else {
                session.setAttribute("admin", vo.getData());

                return "forward:/index.jsp";
            }
        }
       return null;
    }





    @RequestMapping("/logout")
    public String logout(HttpSession session,String usertype) {
        session.removeAttribute("admin"+"customAccount");

            return "forward:/login.jsp";
        }
    }

