package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
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
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public String login(String username, String password, @RequestParam String usertype, HttpSession session) {
        ResultVo vo;
        if (usertype.equals("user")) {
            vo = userService.login(username, password);
        } else {
            vo = adminService.login(username, password);
        }


        if (vo.getSuccess()) {
            //  如果是200说明是用户登录成功
            if (vo.getCode().equals(200)) {
                session.setAttribute("customAccount", vo.getData());

                return "forward:/index2.jsp";
            } else {
                session.setAttribute("admin", vo.getData());

                return "forward:/index.jsp";
            }
        }

        return null;
    }
    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv,HttpSession session ,HttpServletResponse response){
        //销毁session
        session.invalidate();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        mv.setViewName("redirect:/login.jsp");


        return mv;
    }
}
