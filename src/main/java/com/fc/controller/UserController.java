package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("adminLogin")
    public ModelAndView adminLogin(ModelAndView mv,
                                   HttpSession session,
                                   HttpServletResponse response,
                                   Admin admin,
                                   Cookie cookie){


       ResultVo result= userService.adminLogin(admin.getPassword(),admin.getName());
       if (result.getCode()==200){
           session.setAttribute("user",admin);
           cookie = new Cookie("JSESSIONID",session.getId());
           cookie.setMaxAge(30*60);
           mv.addObject(admin);
           mv.setViewName("redirect:/resources/META-INF/static/index.jsp");
       }else {
           cookie.setMaxAge(-1);
           session.removeAttribute("user");
           mv.setViewName("redirect:login.jsp");
       }
       return mv;
    }

}
