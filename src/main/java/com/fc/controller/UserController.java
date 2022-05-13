package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("adminLogin")
public String loginPage() {
    return "login";
}

    @PostMapping("login")
    public String login(String username, String password, HttpSession session) {

        Admin admin = userService.login(username, password);

        if (admin != null) {
            session.setAttribute("username", username);

            if (admin.getName().equals("admin")) {
                return "redirect:/admin/adminList";
            } else if (admin.getName().equals("teacher")) {
                return "redirect:/teacher/showCourse";
            } else if (admin.getName().equals("student")) {
                return "redirect:/student/showCourse";
            }
        }

        return "login";
    }
}
